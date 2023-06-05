package com.example.May2023.Kafka;

import com.example.May2023.Model.Emp;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaProducerService {
    private static String topicName = "emp.june2023.topic";

    @Autowired
    KafkaTemplate<String, Emp> kafkaTemplate;

    public String sendSimpleMessage(Emp emp) throws JsonProcessingException {

        Message<Emp> message = MessageBuilder
                .withPayload(emp)
                .setHeader(KafkaHeaders.TOPIC, topicName)
                .build();

        ListenableFuture<SendResult<String, Emp>> future = kafkaTemplate.send(message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Emp>>() {
            public void onSuccess(SendResult<String, Emp> result) {
                System.out.println("Sent message=[" + emp.getEmpno() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + emp.getEmpno() + "] due to : " + ex.getMessage());
            }
        });
        return "Success";
    }

}

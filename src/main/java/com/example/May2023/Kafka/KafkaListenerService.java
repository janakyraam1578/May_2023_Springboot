package com.example.May2023.Kafka;

import com.example.May2023.Model.Emp;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerService {
    @KafkaListener(topics = "emp.june2023.topic", groupId = "user_group")
    public void consumeUser1(ConsumerRecord<String, Emp> consumerRecord) {

        System.out.println("CONSUMER RECORD: "+consumerRecord.value());
    }
}

package com.example.May2023.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;

@Service
public class CalculateRestService {
    @Autowired
    RestTemplate restTemplate;

    @Value("${calculate.add.url}")
    private String calculateAddUrl;

    //private String calculateAddUrl = "http://localhost:9010/march2023/calculate/add/12/23";

    public double calculateAddtion() {

        HttpEntity<String> entity = new HttpEntity<String>(createHeader());

        ResponseEntity<Object> responseEntity =
                restTemplate.exchange(calculateAddUrl, HttpMethod.GET, entity, Object.class);

        return (Double) responseEntity.getBody();
    }

    private HttpHeaders createHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //Authentication details
        String authentication = "user:user"; // username + ":" + password
        byte[] encodeAuth = Base64.getEncoder().encode(authentication.getBytes());
        String authenticationHeader = "Basic " + new String(encodeAuth);

        headers.set("Authorization", authentication);

        return headers;
    }
}

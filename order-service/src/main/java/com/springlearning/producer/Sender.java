package com.springlearning.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload) {
        kafkaTemplate.send("payment.t", payload);
    }

}

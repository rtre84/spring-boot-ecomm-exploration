package com.springlearning.paymentservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

public class Receiver {

    @KafkaListener(topics = "payment.t")
    public void receive(String payload) {
        System.out.println("Payload Received: " + payload);
    }
}

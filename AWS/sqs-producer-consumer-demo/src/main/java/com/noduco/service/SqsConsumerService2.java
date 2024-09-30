package com.noduco.service;

import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class SqsConsumerService2 {
	
	@SqsListener("myqueue")
    public void consumeMessage(String message) {
        System.out.println("Consumer 2 received message: " + message);
    }
}

package com.spring.aws.services.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SqsConsumer2 {

    @SqsListener("spring-aws-queue")
    public void consumeMessage(String message) {
        log.info("Message consumed by SqsConsumer1: " + message);
    }

}

package com.noduco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.CreateQueueResponse;
import software.amazon.awssdk.services.sqs.model.DeleteQueueRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

@Component
public class SqsConsumerService1 {
	
    @Autowired
	private SqsClient sqsClient;
    
    @Value("${aws.sqs.queue.url}")
    private String queueUrl ;
    
    @Scheduled(fixedDelay = 5000)  // Poll every 5 seconds
    public void consumeMessages() {
    	System.out.println("Inside consumeMessage function");
        ReceiveMessageRequest receiveRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10)
                .build();

        List<Message> messages = sqsClient.receiveMessage(receiveRequest).messages();

        for (Message message : messages) {
            System.out.println("Message received: " + message.body());

            // Process the message

            Delete the message from the queue
           DeleteMessageRequest deleteRequest = DeleteMessageRequest.builder()
                   .queueUrl(queueUrl)
                   .receiptHandle(message.receiptHandle())
                   .build();

           sqsClient.deleteMessage(deleteRequest);
        }
    }
    
}

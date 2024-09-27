package com.spring.aws.services.producer;


import com.amazonaws.services.sqs.AmazonSQS;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class SqsProducerService {


    private final AmazonSQS amazonSQSClient;

    private final ObjectMapper objectMapper;


    private final QueueMessagingTemplate queueMessagingTemplate;




//    public void sendMessage(String queueName, String message) {
//
//        try{
//            String queueUrl = amazonSQSClient.getQueueUrl(queueName).getQueueUrl();
//            log.info("Sending message to queue: " + queueUrl);
//            Message build = Message.builder()
//                    .body(message).build();
//
//
//            amazonSQSClient.sendMessage(queueUrl, objectMapper.writeValueAsString(build));
//        }catch (Exception e){
//           log.warn("Error while sending message to SQS: " + e.getMessage());
//        }
//
//
//

    public void sendMessage(String queueName, String message) {
        queueMessagingTemplate.convertAndSend("spring-aws-queue", message);
    }


}

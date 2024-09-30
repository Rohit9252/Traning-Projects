package com.noduco.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.noduco.service.SQSMessageReceiver1;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;

import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AwsSqsConfiguration {

	
	    @Bean
	    public SqsClient sqsClient(@Value("${aws.accessKeyId}") String accessKeyId,
	            @Value("${aws.secretKey}") String secretKey,
	            @Value("${aws.region}") String region) {
	    	
	    	return SqsClient.builder()
	        .region(Region.US_EAST_1)  // Update region
	        .credentialsProvider(StaticCredentialsProvider.create(
	                AwsBasicCredentials.create(accessKeyId, secretKey)))
	        .build();
	    	
	    }
	 
//	 @Bean
//    @Primary
//    public AmazonSQSAsync amazonSQSAsync(@Value("${aws.accessKeyId}") String accessKeyId,
//     @Value("${aws.secretKey}") String secretKey,
//     @Value("${aws.region}") String region) {
//	        return AmazonSQSAsyncClientBuilder.standard()
//	            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8889", region))
//	            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKeyId, secretKey)))
//	            .build();
//	    }
//
//	   
////	 @Bean
////	    public SimpleMessageListenerContainer simpleMessageListenerContainer(
////	            AmazonSQSAsync amazonSQSAsync) {
////
////	        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
////	        container.setAmazonSqs(amazonSQSAsync);
////	        
////	        container.se;
////	        .setQueueNames(Arrays.asList("YOUR_QUEUE_URL"));   
////
////	        container.setMessageListener(new SQSMessageReceiver1());
////	        return container;
////	    }
//	
//	
//	    @Bean
//	    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync sqsClient) {
//	        return new QueueMessagingTemplate(sqsClient);
//	    }
	    
	   
}

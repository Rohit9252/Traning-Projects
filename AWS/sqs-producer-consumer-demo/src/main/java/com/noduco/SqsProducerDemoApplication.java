package com.noduco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SqsProducerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsProducerDemoApplication.class, args);
	}

}

package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FetchApiUsingSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(FetchApiUsingSpringBoot.class, args);
    }


    @Bean
    public RestTemplate getTemplate() {
    	return new RestTemplate();
    }

}

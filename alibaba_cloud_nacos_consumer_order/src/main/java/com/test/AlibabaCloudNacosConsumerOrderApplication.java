package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class AlibabaCloudNacosConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaCloudNacosConsumerOrderApplication.class, args);
    }

}

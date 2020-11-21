package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaCloudProviderPayment3Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaCloudProviderPayment3Application.class, args);
    }

}

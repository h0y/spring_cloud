package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaCloudProviderPayment4Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaCloudProviderPayment4Application.class, args);
    }

}

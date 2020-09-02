package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 用于向作为服务中心的 zookeeper 注册服务
@EnableDiscoveryClient
public class SpringCloudProviderPaymentZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProviderPaymentZookeeperApplication.class, args);
    }

}

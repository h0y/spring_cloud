package com.test;

import com.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "spring-cloud-payment-service", configuration = MySelfRule.class)
public class SpringCloudConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsumerOrderApplication.class, args);
    }

}

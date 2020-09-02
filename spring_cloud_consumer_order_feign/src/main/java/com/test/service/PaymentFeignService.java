package com.test.service;

import com.test.entities.CommonResult;
import com.test.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "spring-cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    String paymentTimeout();
}

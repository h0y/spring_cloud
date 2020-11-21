package com.test.controller;

import com.test.entities.CommonResult;
import com.test.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static HashMap<Long, Payment> map = new HashMap<>();
    static {
        map.put(1L, new Payment(1L, "bea6c7e0-d4fe-4231-851d-da2fbcac4076"));
        map.put(2L, new Payment(2L, "545bbc22-97b5-4b73-8d97-d9de2881213c"));
        map.put(3L, new Payment(3L, "4fee4961-c45d-47a3-8372-b90540a44e54"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "sql, server port:"
                + serverPort, payment);
        return result;
    }
}

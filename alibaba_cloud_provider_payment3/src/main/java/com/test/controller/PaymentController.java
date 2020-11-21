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
        map.put(1L, new Payment(1L, "e05fa95e-3410-4ee0-b16c-baa400af331f"));
        map.put(2L, new Payment(2L, "0c854497-2f5f-4d87-b540-e918f939ca24"));
        map.put(3L, new Payment(3L, "81b3a485-9a8c-437e-88f5-76ef2f27a46b"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = map.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "sql, server port:"
                + serverPort, payment);
        return result;
    }
}

package com.test.controller;

import com.test.entities.CommonResult;
import com.test.entities.Payment;
import com.test.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        System.out.println("insert:" + result);

        if (result > 0) {
            return new CommonResult(200, "insert success, server port: " + serverPort, result);
        }

        return new CommonResult(500, "insert failure", null);
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        System.out.println("query:" + payment);

        if (payment != null) {
            return new CommonResult(200, "query success, server port: " + serverPort, payment);
        }

        return new CommonResult(200, "no data found", null);
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        // Eureka Server 中的服务
        List<String> services = discoveryClient.getServices();
        for (String element: services) {
            System.out.println("service: " + element);

            // 当前服务的实例（payment8080、payment8081）
            List<ServiceInstance> instances = discoveryClient.getInstances(element);
            for (ServiceInstance instance : instances) {
                // 服务名-主机名-端口-URI
                System.out.println(instance.getServiceId() + "-" + instance.getHost()
                        + "-" + instance.getPort() + "-"  + instance.getUri());
            }
        }
        return discoveryClient;
    }

    @GetMapping(value = "/payment/timeout")
    public String paymentTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi, payment zipkin server fall back!";
    }
}

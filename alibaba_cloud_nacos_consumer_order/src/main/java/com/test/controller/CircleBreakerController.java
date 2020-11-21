package com.test.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.test.entities.CommonResult;
import com.test.entities.Payment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://alibaba-cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback") //没有配置
    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    //@SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
    //       exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/"+id,
                CommonResult.class,id);

        if (id == 4) {
            throw new IllegalArgumentException ("Id - IllegalArgumentException");
        }else if (result.getData() == null) {
            throw new NullPointerException ("Id - NullPointerException");
        }

        return result;
    }

    // fallback
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult(777, "hanlder fallback, exception: "
                + e.getMessage(), payment);
    }

    // blockHandler
    public CommonResult blockHandler(@PathVariable Long id, BlockException blockException) {
        Payment payment = new Payment();
        return new CommonResult(444, "block handler - sentinel block exception: "
                + blockException.getMessage(),payment);
    }
}

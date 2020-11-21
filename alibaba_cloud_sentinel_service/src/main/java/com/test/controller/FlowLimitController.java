package com.test.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTMLDocument;

@RestController
public class FlowLimitController {

    @GetMapping("/testa")
    public String testA() {
        return "test a";
    }

    @GetMapping("/testb")
    public String testB() {
        return "test b";
    }

    @GetMapping("/testc")
    public String testC() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "test c";
    }

    @GetMapping("/testd")
    public String testD() {
        int age = 10 / 0;
        return "test d";
    }

    @GetMapping("/teste")
    public String testE() {
        int age = 10 / 0;
        return "test d";
    }

    @GetMapping("/testHotkey")
    // blockHandler 用于设置在 Sentinel dashboard 设置好的热点规则违反后的处理方法
    @SentinelResource(value = "testHotkey", blockHandler = "dealTestHotkey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "test Hot Key";
    }

    public String dealTestHotkey(String p1, String p2, BlockException exception) {
        return "deal test Hot key";
    }
}

package com.test.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.test.entities.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(777, "customer global handler exception1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(777, "customer global handler exception2");
    }
}

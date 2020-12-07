package com.study.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.study.springcloud.entity.CommonResult;
import com.study.springcloud.entity.Payment;

/**
 * @author Zh
 * @date 2020/12/05 14:50
 */
public class CustomerHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult<>(444, "按客户自定义，global-----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult<>(444, "按客户自定义，global-----2");
    }
}

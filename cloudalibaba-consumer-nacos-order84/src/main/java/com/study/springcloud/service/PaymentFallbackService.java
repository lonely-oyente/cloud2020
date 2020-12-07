package com.study.springcloud.service;

import com.study.springcloud.entity.CommonResult;
import com.study.springcloud.entity.Payment;
import org.springframework.stereotype.Service;

/**
 * @author Zh
 * @date 2020/12/05 16:34
 */
@Service
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(4444, "服务降级返回，----PaymentFallbackService", new Payment(id, "errorSerial"));
    }
}

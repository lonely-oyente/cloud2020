package com.study.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Zh
 * @date 2020/10/25 8:11
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "---PaymentFallbackService fall back paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "---PaymentFallbackService fall back paymentInfo_Timeout";
    }
}

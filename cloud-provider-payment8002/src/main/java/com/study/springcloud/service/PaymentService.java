package com.study.springcloud.service;

import com.study.springcloud.entity.Payment;

/**
 * @author Zh
 * @date 2020/10/21 15:23
 */
public interface PaymentService {

    int add(Payment payment);

    Payment getPaymentById(Long id);
}

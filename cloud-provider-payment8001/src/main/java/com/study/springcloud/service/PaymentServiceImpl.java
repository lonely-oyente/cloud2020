package com.study.springcloud.service;

import com.study.springcloud.dao.PaymentDao;
import com.study.springcloud.entity.Payment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Zh
 * @date 2020/10/21 15:42
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}

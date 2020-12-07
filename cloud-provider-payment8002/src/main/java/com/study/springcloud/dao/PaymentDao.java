package com.study.springcloud.dao;

import com.study.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zh
 * @date 2020/10/21 15:23
 */
@Mapper
public interface PaymentDao {

    int add(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

    List<Payment> queryAll();

}

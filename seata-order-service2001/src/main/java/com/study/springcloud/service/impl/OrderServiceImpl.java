package com.study.springcloud.service.impl;

import com.study.springcloud.dao.OrderDao;
import com.study.springcloud.entity.Order;
import com.study.springcloud.service.AccountService;
import com.study.springcloud.service.OrderService;
import com.study.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Zh
 * @date 2020/12/07 9:48
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    public void create(Order order) {
        //1.新建订单
        log.info("------>开始新建订单");
        orderDao.insert(order);

        //2.扣减库存
        log.info("------>订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("------>订单微服务开始调用库存，扣减end");

        //3.扣减账户余额
        log.info("------>订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("------>订单微服务开始调用账户，扣减end");

        //4.修改订单的状态，从0到1，1代表已经完成
        log.info("------>修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("------>修改订单状态结束");

        log.info("------>新建订单结束");
    }
}

package com.study.springcloud.service.impl;

import com.study.springcloud.dao.AccountDao;
import com.study.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Zh
 * @date 2020/12/07 11:01
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
           log.info("------->account-service中扣减账户余额开始");
           accountDao.decrease(userId, money);
           log.info("------->account-service中扣减账户余额结束");
    }
}

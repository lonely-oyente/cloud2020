package com.study.springcloud.service;

import java.math.BigDecimal;

/**
 * @author Zh
 * @date 2020/12/07 11:00
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}

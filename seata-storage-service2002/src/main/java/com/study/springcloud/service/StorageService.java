package com.study.springcloud.service;

/**
 * @author Zh
 * @date 2020/12/07 10:41
 */
public interface StorageService {

    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}

package com.study.springcloud.dao;

import com.study.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Zh
 * @date 2020/12/07 9:31
 */
@Mapper
public interface OrderDao {

    void insert(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}

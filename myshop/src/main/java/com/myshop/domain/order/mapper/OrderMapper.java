package com.myshop.domain.order.mapper;

import com.myshop.domain.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    Order selectById(int id);
    List<Order> selectByUserId(String userId);

    void insert(Order order);
}

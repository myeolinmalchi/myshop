package com.myshop.domain.order.mapper;

import com.myshop.domain.order.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderDetailMapper {
    OrderDetail selectById(int id);
    List<OrderDetail> selectByOrderId(int orderId);
    void insert(OrderDetail orderDetail);
}

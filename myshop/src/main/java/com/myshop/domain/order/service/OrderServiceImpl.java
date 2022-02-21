package com.myshop.domain.order.service;

import com.myshop.domain.order.entity.vCart;
import com.myshop.domain.order.entity.Order;
import com.myshop.domain.order.entity.OrderDetail;
import com.myshop.domain.order.mapper.OrderDetailMapper;
import com.myshop.domain.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    OrderMapper orderMapper;
    OrderDetailMapper orderDetailMapper;

    @Autowired
    OrderServiceImpl(OrderMapper orderMapper, OrderDetailMapper orderDetailMapper){
        this.orderDetailMapper = orderDetailMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public void orderOneProduct(vCart vCart) {
        Order order = new Order(vCart.getUserId(), 0);
        orderMapper.insert(order);
        orderDetailMapper.insert(cartToOrderDetail(order.getOrderId(), vCart));
    }

    @Override
    public void orderProducts(List<vCart> vCartList) {
        Order order = new Order(vCartList.get(0).getUserId(), 0);
        orderMapper.insert(order);
        System.out.println(order.getOrderId());
        vCartList.stream()
                .map(c -> cartToOrderDetail(order.getOrderId(), c))
                .forEach(orderDetailMapper::insert);
    }

    @Override
    public OrderDetail cartToOrderDetail(int orderId, vCart vCart) {
        return new OrderDetail(
            orderId,
            vCart.getProductId(),
            vCart.getName(),
            vCart.getQuantity(),
            0
        );
    }

    @Override
    public void nextProcess(int orderStatus) {

    }

    @Override
    public List<Order> getOrderList(String userId) {
        List<Order> orders = orderMapper.selectByUserId(userId);
        orders.forEach(o->o.setOrderDetailList(orderDetailMapper.selectByOrderId(o.getOrderId())));
        return orders;
    }

}

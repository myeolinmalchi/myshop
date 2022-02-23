package com.myshop.domain.order.service;

import com.myshop.domain.order.entity.Cart;
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
    public void orderOneProduct(Cart cart) {
        Order order = new Order(cart.getUserId(), 0);
        orderMapper.insert(order);
        orderDetailMapper.insert(cartToOrderDetail(order.getOrderId(), cart));
    }

    @Override
    public void orderProducts(List<Cart> cartList) {
        Order order = new Order(cartList.get(0).getUserId(), 0);
        orderMapper.insert(order);
        System.out.println(order.getOrderId());
        cartList.stream()
                .map(c -> cartToOrderDetail(order.getOrderId(), c))
                .forEach(orderDetailMapper::insert);
    }

    @Override
    public OrderDetail cartToOrderDetail(int orderId, Cart cart) {
        return new OrderDetail(
            orderId,
            cart.getProductId(),
            cart.getName(),
            cart.getQuantity(),
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

package com.myshop.domain.order.service;

import com.myshop.domain.order.entity.vCart;
import com.myshop.domain.order.entity.Order;
import com.myshop.domain.order.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    public void orderOneProduct(vCart vCart);
    public void orderProducts(List<vCart> vCartList);
    public OrderDetail cartToOrderDetail(int orderId, vCart vCart);
    public void nextProcess(int orderStatus);
    public List<Order> getOrderList(String userId);
}
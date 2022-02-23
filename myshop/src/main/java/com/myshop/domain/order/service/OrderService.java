package com.myshop.domain.order.service;

import com.myshop.domain.order.entity.Cart;
import com.myshop.domain.order.entity.Order;
import com.myshop.domain.order.entity.OrderDetail;

import java.util.List;

public interface OrderService {
    public void orderOneProduct(Cart cart);
    public void orderProducts(List<Cart> cartList);
    public OrderDetail cartToOrderDetail(int orderId, Cart vCart);
    public void nextProcess(int orderStatus);
    public List<Order> getOrderList(String userId);
}
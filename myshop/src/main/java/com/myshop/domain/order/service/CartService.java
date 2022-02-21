package com.myshop.domain.order.service;

import com.myshop.domain.order.entity.Cart;
import com.myshop.domain.order.entity.vCart;
import com.myshop.domain.user.entity.User;

import java.util.List;

public interface CartService {
    public int addCart(Cart cart);
    public User remCart(int cartId, User user);
    public User updateQuantity(int cartId, int quantity, User user);

    public List<vCart> myvCartList(String userId);
    public List<Cart> myCartList(String userId);
}

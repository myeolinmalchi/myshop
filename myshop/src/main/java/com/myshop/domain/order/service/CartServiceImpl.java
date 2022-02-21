package com.myshop.domain.order.service;

import com.myshop.domain.order.entity.Cart;
import com.myshop.domain.order.entity.vCart;
import com.myshop.domain.order.mapper.CartMapper;
import com.myshop.domain.order.mapper.vCartMapper;
import com.myshop.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{

    private final CartMapper cartMapper;
    private final vCartMapper vcartMapper;
    @Autowired CartServiceImpl(CartMapper cartMapper, vCartMapper vcartMapper){
        this.cartMapper = cartMapper;
        this.vcartMapper = vcartMapper;
    }

    @Override
    public int addCart(Cart cart) {
        cartMapper.insert(cart);
        return 0;
    }

    @Override
    public User remCart(int cartId, User user) {
        cartMapper.delete(cartId);
        user.getVcarts().removeIf(c -> c.getCartId()==cartId);
        return user;
    }

    @Override
    public User updateQuantity(int cartId, int quantity, User user) {
        cartMapper.updateQuantity(cartId, quantity);
        user.getVcarts().stream()
                .filter(c -> c.getCartId()==cartId)
                .collect(Collectors.toList())
                .get(0)
                .setQuantity(quantity);

        return user;
    }

    @Override
    public List<vCart> myvCartList(String userId) {
        return vcartMapper.selectByUserId(userId);
    }

    @Override
    public List<Cart> myCartList(String userId){
        return cartMapper.selectByUserId(userId);
    }
}

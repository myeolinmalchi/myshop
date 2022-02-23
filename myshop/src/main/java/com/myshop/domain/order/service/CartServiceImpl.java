package com.myshop.domain.order.service;

import com.myshop.domain.order.entity.Cart;
import com.myshop.domain.order.mapper.CartDetailMapper;
import com.myshop.domain.order.mapper.CartMapper;
import com.myshop.domain.product.mapper.ProductOptionItemMapper;
import com.myshop.domain.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService{

    private final CartMapper cartMapper;
    private final CartDetailMapper cartDetailMapper;
    private final ProductOptionItemMapper itemMapper;

    @Autowired CartServiceImpl(CartMapper cartMapper,
                               CartDetailMapper cartDetailMapper,
                               ProductOptionItemMapper itemMapper){
        this.cartMapper = cartMapper;
        this.cartDetailMapper = cartDetailMapper;
        this.itemMapper = itemMapper;
    }

    @Override
    public int addCart(Cart cart) {
        cartMapper.insert(cart);
        return 0;
    }

    @Override
    public User remCart(int cartId, User user) {
        cartMapper.delete(cartId);
        user.getCarts().removeIf(c -> c.getCartId()==cartId);
        return user;
    }

    @Override
    public User updateQuantity(int cartId, int quantity, User user) {
        cartMapper.updateQuantity(cartId, quantity);
        user.getCarts().stream()
                .filter(c -> c.getCartId()==cartId)
                .collect(Collectors.toList())
                .get(0)
                .setQuantity(quantity);

        return user;
    }

    @Override
    public List<Cart> getCarts(String userId) {
        return cartMapper.selectByUserId(userId);
    }

    @Override
    public List<Cart> getCartsContainOptions(String userId) {
        return getCarts(userId).stream()
                .map(this::fillDetails)
                .collect(Collectors.toList());
    }

    @Override
    public Cart fillDetails(Cart cart) {
        cart.setItems(
                cartDetailMapper.selectByCartId(cart.getCartId()).stream()
                        .map(c -> itemMapper.selectById(c.getOptionItemId()))
                        .peek(i -> cart.setPrice(cart.getPrice()+i.getSurcharge()))
                        .collect(Collectors.toList()));

        return cart;
    }
}

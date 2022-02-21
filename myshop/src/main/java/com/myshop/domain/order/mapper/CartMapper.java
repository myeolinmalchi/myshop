package com.myshop.domain.order.mapper;

import com.myshop.domain.order.entity.Cart;
import com.myshop.domain.order.entity.vCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    Cart selectById(int id);
    List<Cart> selectByUserId(String userId);

    void insert(Cart cart);
    void update(Cart cart);
    void updateQuantity(@Param("cartId") int cartId, @Param("quantity") int quantity);
    void delete(int cartId);
    void deleteByUserId(String userId);
}

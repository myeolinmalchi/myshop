package com.myshop.domain.order.mapper;

import com.myshop.domain.order.entity.CartDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartDetailMapper {
    CartDetail select(int id);
    List<CartDetail> selectByCartId(int cartId);
}

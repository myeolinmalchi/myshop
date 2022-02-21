package com.myshop.domain.order.mapper;

import com.myshop.domain.order.entity.vCart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface vCartMapper {
    vCart selectByCartId(int cartId);
    List<vCart> selectByUserId(String userId);
}

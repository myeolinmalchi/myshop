package com.myshop.domain.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CartDetailMapper {
    void select(int id);
}

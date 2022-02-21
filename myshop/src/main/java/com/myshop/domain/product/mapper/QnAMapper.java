package com.myshop.domain.product.mapper;

import com.myshop.domain.product.entity.QnA;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QnAMapper {
    QnA selectByProductId(int productId);
    List<QnA> selectByUserId(String userId);
}

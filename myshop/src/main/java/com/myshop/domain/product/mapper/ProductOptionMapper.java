package com.myshop.domain.product.mapper;

import com.myshop.domain.product.entity.ProductOption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductOptionMapper {
    List<ProductOption> selectById(int productId);
}

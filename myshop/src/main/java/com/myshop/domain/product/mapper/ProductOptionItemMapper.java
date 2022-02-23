package com.myshop.domain.product.mapper;

import com.myshop.domain.product.entity.ProductOption;
import com.myshop.domain.product.entity.ProductOptionItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductOptionItemMapper {
    ProductOptionItem selectById(int id);
    List<ProductOptionItem> selectByProductOptionId(int optionId);
    List<ProductOptionItem> selectByProductOption(ProductOption option);
}

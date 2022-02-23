package com.myshop.domain.product.mapper;

import com.myshop.domain.product.entity.Product;
import com.myshop.domain.product.entity.ProductOption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductOptionMapper {
    ProductOption selectById(int id);
    List<ProductOption> selectByProductId(int productId);
    List<ProductOption> selectByProduct(Product product);
}

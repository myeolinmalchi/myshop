package com.myshop.domain.product.mapper;

import com.myshop.domain.product.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface ProductMapper {
    Product selectById(int productId);
    List<Product> selectByCategory(String code);
    List<Product> selectByNameWithCategory(String name, String code);
    List<Product> selectByName(String name);

    void update(Product product);

    void increaseReviewCount(int productId);
    void decreaseReviewCount(int productId);

    void increaseRating(int productId, int rating);
    void decreaseRating(int productId, int rating);
}

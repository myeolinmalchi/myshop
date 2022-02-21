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

//  List<Product> selectByNameWithCategoryHasLimit(String name, String code, int limit);

    void update(Product product);
//    void updateById(@Param("productId") int productId,
//                    @Param("column") String column,
//                    @Param("value")String value);
//
//    void updateById(@Param("productId") int productId,
//                    @Param("column") String column,
//                    @Param("value") int value);

    void increaseReviewCount(int productId);
    void decreaseReviewCount(int productId);

    void increaseRating(int productId, int rating);
    void decreaseRating(int productId, int rating);
}

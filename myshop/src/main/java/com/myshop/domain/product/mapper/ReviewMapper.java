package com.myshop.domain.product.mapper;

import com.myshop.domain.product.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReviewMapper {
    Review selectByProductId(int productId);
    List<Review> selectByUserId(String userId);

    void increaseRecommend(int reviewId);

    void insert(Review review);
    void delete(int reviewId);
    void update(Review review);
}

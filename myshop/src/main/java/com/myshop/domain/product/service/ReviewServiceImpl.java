package com.myshop.domain.product.service;

import com.myshop.domain.product.entity.Review;
import com.myshop.domain.product.mapper.ProductMapper;
import com.myshop.domain.product.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    final private ProductMapper productMapper;
    final private ReviewMapper reviewMapper;

    @Autowired
    public ReviewServiceImpl(ProductMapper productMapper, ReviewMapper reviewMapper) {
        this.productMapper = productMapper;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public void writeReview(Review review) {
        productMapper.increaseReviewCount(review.getProductId());
        productMapper.increaseRating(review.getProductId(), review.getRating());
        reviewMapper.insert(review);
    }

    @Override
    public void deleteReview(Review review) {
        productMapper.decreaseReviewCount(review.getProductId());
        productMapper.decreaseRating(review.getProductId(), review.getRating());
        reviewMapper.delete(review.getReviewId());
    }
}

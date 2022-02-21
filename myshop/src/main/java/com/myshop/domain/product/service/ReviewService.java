package com.myshop.domain.product.service;

import com.myshop.domain.product.entity.Review;

public interface ReviewService {
    public void writeReview(Review review);
    public void deleteReview(Review review);
}

package com.myshop.domain.product.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class Review {
    @NonNull private int productId;
    private int reviewId;
    @NonNull private String userId;
    @NonNull private int rating;
    @NonNull private String title;
    @NonNull private String content;
    private String comment;
    private Date reviewDate;
    private int recommend;
}

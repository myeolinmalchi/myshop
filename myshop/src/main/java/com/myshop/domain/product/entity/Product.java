package com.myshop.domain.product.entity;

import lombok.Data;

import java.util.List;

@Data
public class Product {
    private int productId;
    private String name;
    private String sellerId;
    private int price;
    private String categoryCode;
    private String detailInfo;
    private String thumbnail;
    private int reviewCount;
    private int rating;
    List<ProductOption> options;
}

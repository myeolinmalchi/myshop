package com.myshop.domain.product.entity;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String name;
    private String sellerId;
    private int price;
    private String categoryCode;
    private String detailInfo;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String thumbnail;
    private int reviewCount;
    private int rating;
}

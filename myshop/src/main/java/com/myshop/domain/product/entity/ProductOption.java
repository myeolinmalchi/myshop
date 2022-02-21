package com.myshop.domain.product.entity;

import lombok.Data;

@Data
public class ProductOption {
    private int productId;
    private int productOptionId;
    private String name;
    private char category;
    private int sequence;
    private int surcharge;
    private String images;
}

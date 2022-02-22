package com.myshop.domain.product.entity;

import lombok.Data;

import java.util.List;

@Data
public class ProductOption {
    private int productId;
    private int productOptionId;
    private String name;
    private int optionSequence;
    private String images;

    List<ProductOptionItem> items;
}

package com.myshop.domain.product.entity;

import lombok.Data;

@Data
public class ProductOptionItem {
    int productOptionId;
    int productOptionItemId;
    String name;
    int itemSequence;
    int surcharge;
}

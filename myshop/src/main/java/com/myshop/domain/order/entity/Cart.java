package com.myshop.domain.order.entity;

import com.myshop.domain.product.entity.ProductOptionItem;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Cart {
    @NonNull String userId;
    private int cartId;
    @NonNull private String name;
    @NonNull private int productId;
    @NonNull private int price;
    @NonNull private int quantity;
    private Date addedDate;
    List<ProductOptionItem> items;
}

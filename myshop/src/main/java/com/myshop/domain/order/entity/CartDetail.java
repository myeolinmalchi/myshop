package com.myshop.domain.order.entity;

import lombok.Data;

@Data
public class CartDetail {
    private int cartId;
    private int cartDetailId;
    private int optionItemId; // product_option_items
}

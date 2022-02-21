package com.myshop.domain.order.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

// carts 테이블 참조

@Data
@RequiredArgsConstructor
public class Cart {
    @NonNull String userId;
    private int cartId;
    @NonNull private int productId;
    private int optionA;
    private int optionB;
    private int optionC;
    private int optionD;
    private int optionE;
    @NonNull private int quantity;
    private Date addedDate;
}

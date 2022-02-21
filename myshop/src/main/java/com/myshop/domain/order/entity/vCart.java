package com.myshop.domain.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

// v_carts 뷰 참조
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class vCart {
    private int cartId;
    String userId;
    @NonNull private int productId;
    String name;
    @NonNull private int price;
    @NonNull private int quantity;
    private Date addedDate;

    public void setUserId(Object userId){
        this.userId = userId.toString();
    }
    public void setName(Object name){
        this.name = name.toString();
    }
}

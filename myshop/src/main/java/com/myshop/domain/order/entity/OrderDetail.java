package com.myshop.domain.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    @NonNull private Integer orderId;
    private int orderDetailId;
    @NonNull private Integer productId;
    @NonNull private String name;
    @NonNull private Integer quantity;
    @NonNull private Integer orderDetailStatus;
}

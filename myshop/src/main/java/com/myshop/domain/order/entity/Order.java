package com.myshop.domain.order.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Order {
    @NonNull private String userId;
    private int orderId;
    private Date orderDate;
    @NonNull private int orderStatus;
    private List<OrderDetail> orderDetailList;
}

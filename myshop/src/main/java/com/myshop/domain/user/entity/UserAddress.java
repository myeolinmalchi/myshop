package com.myshop.domain.user.entity;

import lombok.Data;

@Data
public class UserAddress {
    private String userId;
    private int addressId;
    private int priority;
    private String address;
    private String addressDetail;
    private int zipcode;
}

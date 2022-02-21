package com.myshop.domain.user.entity;

import com.myshop.domain.order.entity.vCart;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
public class User {
    @NonNull private String userId;
    @NonNull private String userPw;
    @NonNull private String name;
    @NonNull private String email;
    @NonNull private String phonenumber;
    private Date regdate;

    private List<UserAddress> addresses;
    private List<vCart> vcarts;
}

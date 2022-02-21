package com.myshop.domain.user.service;

import com.myshop.domain.user.entity.User;
import com.myshop.domain.user.entity.UserAddress;

public interface UserService {
    public int login(String userId, String userPw);
    public User login(String userId, String userPw, StringBuilder msg);
    public boolean checkIdExistence(String userId);
    public boolean checkEmailExistence(String email);
    public int register(User user);
    public int register(User user, UserAddress ... addresses);
    public int withdraw(User user);
    public int editProfile(User user);
    public int delAddress(int addressId);
    public int addAddress(UserAddress address);
    public User getUserData(String userId);
}

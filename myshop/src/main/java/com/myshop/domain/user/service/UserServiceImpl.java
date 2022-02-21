package com.myshop.domain.user.service;

import com.myshop.domain.order.service.CartService;
import com.myshop.domain.user.entity.User;
import com.myshop.domain.user.entity.UserAddress;
import com.myshop.domain.user.mapper.UserAddressMapper;
import com.myshop.domain.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final UserAddressMapper userAddressMapper;
    private final CartService cartService;

    @Autowired
    UserServiceImpl(UserMapper userMapper, UserAddressMapper userAddressMapper, CartService cartService){
        this.userMapper = userMapper;
        this.userAddressMapper = userAddressMapper;
        this.cartService = cartService;
    }

    @Override
    public int login(String userId, String userPw) {
        User user = userMapper.selectById(userId);
        if(user==null) return -1; // 존재하지 않는 아이디
        else return user.getUserPw().equals(userPw)?1:0;
    }

    @Override
    public User login(String userId, String userPw, StringBuilder msg) {
        User user = userMapper.selectById(userId);

        if(user == null) msg.append("존재하지 않는 아이디입니다.");
        else if(!user.getUserPw().equals(userPw)) msg.append("비밀번호가 일치하지 않습니다.");
        else{
            user.setVcarts(cartService.myvCartList(userId));
            return user;
        }

        return null;
    }

    @Override
    public boolean checkIdExistence(String userId) {
        User user = userMapper.selectById(userId);
        return (user==null);
    }

    @Override
    public boolean checkEmailExistence(String email) {
        User user = userMapper.selectByEmail(email);
        return (user==null);
    }

    @Override
    public int register(User user) {
        userMapper.insert(user);
        return 0;
    }

    @Override
    public int register(User user, UserAddress... addresses) {
        userMapper.insert(user);
        Arrays.stream(addresses)
                .forEach(userAddressMapper::insert);
        return 0;
    }

    @Override
    public int withdraw(User user) {
        userMapper.delete(user.getUserId());
        return 0;
    }

    @Override
    public int editProfile(User user) {
        userMapper.update(user);
        return 0;
    }

    @Override
    public int delAddress(int addressId) {
        return 0;
    }

    @Override
    public int addAddress(UserAddress address) {
        return 0;
    }

    @Override
    public User getUserData(String userId) {
        User user = userMapper.selectById(userId);
        user.setAddresses(userAddressMapper.selectAddressesByUserId(userId));
        return user;
    }
}

package com.myshop.domain.user.mapper;

import com.myshop.domain.user.entity.UserAddress;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserAddressMapper {
    List<UserAddress> selectAddressesByUserId(String userId);
    void insert(UserAddress userAddress);
    void update(UserAddress userAddress);
    void delete(String userAddressId);
}

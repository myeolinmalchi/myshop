package com.myshop.domain.user.mapper;

import com.myshop.domain.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {
    User selectById(String userId);
    User selectByEmail(String email);

    Optional<User> select(@Param("type") String type, @Param("value") String value);

    void insert(User user);
    void update(User user);
    void delete(String userId);
}

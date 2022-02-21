package com.myshop.domain.user.entity;

import com.myshop.domain.user.mapper.UserMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

@Getter
public enum UserValidator {
    USERID("user_id","^[a-zA-Z0-9]*$"),
    USERPW("user_pw","^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$"),
    NAME("name","^[가-힣]*$"),
    EMAIL("email","^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$"),
    PHONENUMBER("phonenumber","^\\\\d{3}-\\\\d{3,4}-\\\\d{4}$");

    @Component
    static class ValidationInjector{
        private final UserMapper userMapper;

        @Autowired ValidationInjector(UserMapper userMapper){
            this.userMapper = userMapper;
        }

        @PostConstruct public void postConstruct(){
            EnumSet.allOf(UserValidator.class)
                    .forEach(v->v.setUserMapper(userMapper));
        }
    }

    @Setter UserMapper userMapper;

    final private String type;
    final private String pattern;

    final private UnaryOperator<TestTextDTO> emptyCheck;
    final private UnaryOperator<TestTextDTO> patternCheck;
    final private UnaryOperator<TestTextDTO> overlapCheck;

    UserValidator(String type,String pattern){
        this.pattern = pattern;
        this.type = type;

        emptyCheck = text -> (text.test(String::isEmpty))?
                (text.invalidText("필수 항목입니다.")):(text);

        patternCheck = text -> (text.test(
                str -> !Pattern.matches(pattern, str)))?
                (text.invalidText("올바르지 않은 형식입니다.")):(text);

        overlapCheck = text -> (text.test(
                str -> userMapper.select(type, str).isPresent()))?
                (text.invalidText("이미 사용중입니다.")):(text);
    }

    public String test(String value){
        if(type=="user_id" || type=="email"){
            return emptyCheck.andThen(patternCheck)
                    .andThen(overlapCheck)
                    .apply(new TestTextDTO(value))
                    .getMsg();
        }else{
            return emptyCheck.andThen(patternCheck)
                    .apply(new TestTextDTO(value))
                    .getMsg();
        }
    }
}

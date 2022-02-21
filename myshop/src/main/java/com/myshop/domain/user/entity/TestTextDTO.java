package com.myshop.domain.user.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@Data
@RequiredArgsConstructor
public class TestTextDTO {
    @NonNull private String str;
    private String msg = null;
    private boolean is_valid = true;

    boolean test(Predicate<String> p){
        return this.is_valid && p.test(str);
    }

    TestTextDTO invalidText(String msg){
        this.is_valid = false;
        this.msg = msg;
        return this;
    }
}

package com.myshop.domain.product.entity;

import lombok.Data;

@Data
public class vCategory {
    private String code;
    private String name;
    private int depth;
    private int sequence;

    void setCode(Object code){ this.code = code.toString(); }
    void setName(Object name){ this.name = name.toString(); }
}

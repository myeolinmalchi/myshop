package com.myshop.domain.product.entity;

import lombok.Data;

@Data
public class Category {
    private int categoryId;
    private String group_id;
    private String name;
    private int depth;
    private int sequence;
    private int parentDepth;
    private int parentSequence;
}

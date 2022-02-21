package com.myshop.domain.product.entity;

import lombok.Data;

@Data
public class QnA {
    private int productId;
    private int qnaId;
    private String userId;
    private String question;
    private String answer;
}

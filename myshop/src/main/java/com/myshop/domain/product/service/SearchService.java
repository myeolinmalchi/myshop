package com.myshop.domain.product.service;


import com.myshop.domain.product.entity.Product;

import java.util.List;

public interface SearchService {
    List<Product> searchWithLimit(String name, String code, int limit);
}

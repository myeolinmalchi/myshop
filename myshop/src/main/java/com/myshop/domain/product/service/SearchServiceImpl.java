package com.myshop.domain.product.service;

import com.myshop.domain.product.entity.Product;
import com.myshop.domain.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService{

    final private ProductMapper productMapper;

    @Autowired
    public SearchServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> searchWithLimit(String name, String code, int limit) {
        return productMapper.selectByNameWithCategory(name, code);
    }
}

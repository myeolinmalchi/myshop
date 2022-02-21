package com.myshop.domain.product.service;

import com.myshop.domain.product.entity.vCategory;
import com.myshop.domain.product.mapper.vCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final vCategoryMapper vcategoryMapper;

    @Autowired
    CategoryServiceImpl(vCategoryMapper vcategoryMapper){
        this.vcategoryMapper = vcategoryMapper;
    }


    @Override
    public List<vCategory> getHomeCategories() {
        return vcategoryMapper.getAllMainCategories();
    }
}

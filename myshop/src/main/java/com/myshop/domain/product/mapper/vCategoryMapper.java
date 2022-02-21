package com.myshop.domain.product.mapper;

import com.myshop.domain.product.entity.vCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface vCategoryMapper {
    List<vCategory> getAllCategories();
    List<vCategory> getSiblings(String code);
    List<vCategory> getChildrens(String code);
    List<vCategory> getAllMainCategories();
}

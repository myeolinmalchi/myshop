package com.myshop.domain.product.service;

import com.myshop.domain.product.entity.Product;
import com.myshop.domain.product.entity.ProductOption;
import com.myshop.domain.product.entity.ProductOptionItem;
import com.myshop.domain.product.mapper.ProductMapper;
import com.myshop.domain.product.mapper.ProductOptionItemMapper;
import com.myshop.domain.product.mapper.ProductOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    ProductMapper productMapper;
    ProductOptionMapper optionMapper;
    ProductOptionItemMapper itemMapper;

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper, ProductOptionMapper optionMapper, ProductOptionItemMapper itemMapper) {
        this.productMapper = productMapper;
        this.optionMapper = optionMapper;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<Product> searchProducts(String name, String code) {
        return productMapper.selectByNameWithCategory(name, code);
    }

    @Override
    public List<Product> searchProductsContainOptions(String name, String code) {
        return searchProducts(name, code).stream()
                .map(this::fillOptions)
                .collect(Collectors.toList());
    }

    @Override
    public Product fillOptions(Product product) {
        product.setOptions(
                optionMapper.selectByProduct(product).stream()
                        .map(this::fillItems)
                        .collect(Collectors.toList()));
        return product;
    }

    @Override
    public Product fillOptions(int productId) {
        return fillOptions(productMapper.selectById(productId));
    }

    @Override
    public ProductOption fillItems(ProductOption option) {
        option.setItems(itemMapper.selectByProductOption(option));
        return option;
    }

    @Override
    public List<ProductOption> getOptions(int productId) {
        return optionMapper.selectByProductId(productId).stream()
                .peek(o ->
                        o.setItems(itemMapper.selectByProductOptionId(o.getProductOptionId())))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductOptionItem> getItems(int optionId) {
        return itemMapper.selectByProductOptionId(optionId);
    }
}

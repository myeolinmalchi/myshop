package com.myshop.domain.product.service;

import com.myshop.domain.product.entity.Product;
import com.myshop.domain.product.entity.ProductOption;
import com.myshop.domain.product.entity.ProductOptionItem;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String name, String code);
    List<Product> searchProductsContainOptions(String name, String code);

    Product fillOptions(Product product);
    Product fillOptions(int productId);

    ProductOption fillItems(ProductOption option);

    List<ProductOption> getOptions(int productId);
    List<ProductOptionItem> getItems(int optionId);
}

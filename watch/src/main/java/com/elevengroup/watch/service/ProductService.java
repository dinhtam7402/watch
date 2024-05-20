package com.elevengroup.watch.service;

import com.elevengroup.watch.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<Products> getAllProducts(Pageable pageable);
    Products getProductsById(String id);
}

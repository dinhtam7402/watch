package com.elevengroup.watch.service;

import com.elevengroup.watch.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Products> getAllProducts(Pageable pageable);
    Products getProductsById(String id);
    Optional<Products> findProductById(String id);
    Products saveProduct(Products products);

    void deleteProductById(String id);
}

package com.elevengroup.watch.service.Impl;

import com.elevengroup.watch.entity.Products;
import com.elevengroup.watch.repository.CustomerRepository;
import com.elevengroup.watch.repository.ProductRepository;
import com.elevengroup.watch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Products> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Products getProductsById(String id) {
        Optional<Products> optionalProducts = productRepository.findById(id);
        return optionalProducts.orElse(null);
    }
}

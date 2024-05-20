package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, String> {
}

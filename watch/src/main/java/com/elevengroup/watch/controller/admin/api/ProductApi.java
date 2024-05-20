package com.elevengroup.watch.controller.admin.api;

import com.elevengroup.watch.entity.Products;
import com.elevengroup.watch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/product")
public class ProductApi {
    @Autowired
    private ProductService productService;

    @GetMapping("/view/{id}")
    public ResponseEntity<Products> getProductDetails(@PathVariable("id") String id) {
        Products products = productService.getProductsById(id);
        if (products != null) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

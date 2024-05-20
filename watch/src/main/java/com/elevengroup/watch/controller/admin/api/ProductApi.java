package com.elevengroup.watch.controller.admin.api;

import com.elevengroup.watch.entity.Customer;
import com.elevengroup.watch.entity.Products;
import com.elevengroup.watch.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    @PostMapping("/update")
    public ResponseEntity<Products> updateProduct(@RequestBody @Valid Products updateProduct) {
        Optional<Products> optionalProduct = productService.findProductById(updateProduct.getId());
        if (!optionalProduct.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + updateProduct.getId());
        }
        Products product = optionalProduct.get();

        product.setId(updateProduct.getId());
        product.setName(updateProduct.getName());
        product.setDescription(updateProduct.getDescription());
        product.setBrand(updateProduct.getBrand());
        product.setImgUrl(updateProduct.getImgUrl());
        product.setDialColor(updateProduct.getDialColor());
        product.setPrice(updateProduct.getPrice());
        product.setSold(updateProduct.getSold());
        product.setCaseMaterial(updateProduct.getCaseMaterial());
        product.setStrapMaterial(updateProduct.getStrapMaterial());
        product.setMovementType(updateProduct.getMovementType());
        product.setWaterResistance(updateProduct.getWaterResistance());
        product.setCaseDiameter(updateProduct.getCaseDiameter());
        product.setCaseThickness(updateProduct.getCaseThickness());
        product.setPowerReserve(updateProduct.getPowerReserve());

        // Lưu thông tin đã cập nhật
        Products savedProducts = productService.saveProduct(product);

        return ResponseEntity.ok(savedProducts);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id) {
        try {
            productService.deleteProductById(id);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Product");
        }
    }
}

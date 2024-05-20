package com.elevengroup.watch.controller.admin;

import com.elevengroup.watch.entity.Products;
import com.elevengroup.watch.service.PaginationService;
import com.elevengroup.watch.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PaginationService paginationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listProduct(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "15") int size,
                              HttpServletRequest request,
                              Model model) {

        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Products> pageProducts = productService.getAllProducts(pageable);

        paginationService.addPaginationToModel(pageProducts, model, size, request.getRequestURI());

        return "admin/products/list";
    }
}

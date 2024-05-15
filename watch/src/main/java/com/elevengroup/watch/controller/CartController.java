package com.elevengroup.watch.controller;

import com.elevengroup.watch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/cart/{id}", method = RequestMethod.GET)
    public String viewCart(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "cart";
    }
}
    
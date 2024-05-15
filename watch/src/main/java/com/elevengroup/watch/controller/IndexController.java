package com.elevengroup.watch.controller;

import com.elevengroup.watch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
    public String inforProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("infowatch", productRepository.findById(id).orElse(null));
        return "info-product";
    }
}

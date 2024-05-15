package com.elevengroup.watch.controller;

import com.elevengroup.watch.repository.ProductRepository;
import com.elevengroup.watch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewIndex(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            model.addAttribute("username", username);
        }
        model.addAttribute("watchmans", productRepository.findBySex("Nam"));
        model.addAttribute("watchwomans", productRepository.findBySex("Nữ"));
        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String viewSignup() {
        return "signup";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin() {
        return "login";
    }
}

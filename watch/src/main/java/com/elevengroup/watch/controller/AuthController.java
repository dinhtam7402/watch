package com.elevengroup.watch.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @RequestMapping(value = "/")
    public String viewIndex() {
        return "index";
    }

    @RequestMapping(value = "/signup")
    public String viewSignup() {
        return "signup";
    }

    @RequestMapping(value = "/login")
    public String viewLogin() {
        return "login";
    }
}

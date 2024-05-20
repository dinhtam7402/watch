package com.elevengroup.watch.controller.admin;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexAdmin(HttpServletRequest request, Model model) {
        model.addAttribute("requestURI", request.getRequestURI());
        return "admin/index";
    }
}

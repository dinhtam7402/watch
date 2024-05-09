package com.elevengroup.watch.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthAdminController {
    @RequestMapping(value = "/admin/")
    String viewIndexAdmin() {
        return "admin/dashboard";
    }
}

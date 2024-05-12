package com.elevengroup.watch.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AuthAdminController {
    @RequestMapping(value = "/")
    String viewIndexAdmin() {
        return "admin/dashboard";
    }
}

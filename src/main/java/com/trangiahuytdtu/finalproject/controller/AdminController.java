package com.trangiahuytdtu.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/login")
    public String viewAdminLogin(){
        // Trả về url file html
        return "Admin/AdminLogin";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(){
        // Trả về url file html
        return "Admin/AdminHome";
    }
}

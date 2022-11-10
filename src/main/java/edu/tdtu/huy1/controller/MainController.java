package edu.tdtu.huy1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String viewHomePage(){
        // Trả về url file html
        return "HomePage";
    }
}

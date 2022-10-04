package com.trangiahuytdtu.finalproject.controller;

import com.trangiahuytdtu.finalproject.entities.Reader;
import com.trangiahuytdtu.finalproject.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private ReaderService readerService;

    // GetMapping dùng để nhận href từ file html

    @GetMapping("/")
    public String viewHomePage(){
        // Trả về url file html
        return "HomePage";
    }

    @GetMapping("/admin/login")
    public String viewAdminLogin(){
        // Trả về url file html
        return "Admin/AdminLogin";
    }

    @GetMapping("/reader/login")
    public String viewReaderLogin(){
        // Trả về url file html
        return "Reader/ReaderLogin";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(){
        // Trả về url file html
        return "Admin/AdminHome";
    }

    @GetMapping("/reader/home")
    public String viewReaderHomePage(){
        // Trả về url file html
        return "Reader/ReaderHome";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){


        model.addAttribute("reader", new Reader());

        return "Reader/Register";
    }

    @PostMapping("/process_register")
    public String processRegistration(Reader reader){
        readerService.save(reader);
        return "Reader/register_success";
    }
}

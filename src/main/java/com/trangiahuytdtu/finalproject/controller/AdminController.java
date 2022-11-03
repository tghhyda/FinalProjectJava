package com.trangiahuytdtu.finalproject.controller;

import com.trangiahuytdtu.finalproject.Exception.NotFoundException;
import com.trangiahuytdtu.finalproject.service.BookService;
import com.trangiahuytdtu.finalproject.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {
    @Autowired
    ReaderService readerService;

    @Autowired
    BookService bookService;
    @GetMapping("/admin/login")
    public String viewAdminLogin(){
        return "Admin/AdminLogin";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(Model model){
        model.addAttribute("listBooks", bookService.listAllBooks());
        model.addAttribute("listReaders", readerService.listAllReader());
        return "Admin/AdminHome";
    }

    @GetMapping("/admin/book")
    public String viewAdminBook(Model model){
        model.addAttribute("listBooks", bookService.listAllBooks());
        return "Admin/AdminBook";
    }

}
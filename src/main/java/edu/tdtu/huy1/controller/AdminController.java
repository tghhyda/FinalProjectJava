package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.service.BookService;
import edu.tdtu.huy1.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        model.addAttribute("listReaders", readerService.list4LatestReader());
        return "Admin/AdminHome";
    }

    @GetMapping("/admin/book")
    public String viewAdminBook(Model model){
        model.addAttribute("listBooks", bookService.listAllBooks());
        return "Admin/AdminBook";
    }

    @GetMapping("/admin/reader")
    public String viewAdminReader(Model model){
        model.addAttribute("listReaders", readerService.listAllReader());
        return "Admin/AdminReader";
    }

}
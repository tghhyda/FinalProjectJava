package com.trangiahuytdtu.finalproject.controller;

import com.trangiahuytdtu.finalproject.entities.Reader;
import com.trangiahuytdtu.finalproject.entities.TypeOfReader;
import com.trangiahuytdtu.finalproject.service.ReaderService;
import com.trangiahuytdtu.finalproject.service.TypeOfReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @Autowired
    private TypeOfReaderService typeService;

    @GetMapping("/reader/login")
    public String viewReaderLogin(){
        // Trả về url file html
        return "Reader/ReaderLogin";
    }

    @GetMapping("/user/register")
    public String showRegisterForm(Model model){
        model.addAttribute("reader", new Reader());
        List<TypeOfReader> listType = typeService.listAll();
        model.addAttribute("listType", listType);
        return "Reader/Register";
    }

    @PostMapping("/process_register")
    public String processRegistration(Reader reader){
        readerService.save(reader);
        return "Reader/register_success";
    }

    @GetMapping("/reader/home")
    public String viewReaderHomePage(){
        // Trả về url file html
        return "Reader/ReaderHome";
    }
}

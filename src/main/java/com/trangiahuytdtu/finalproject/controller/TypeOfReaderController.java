package com.trangiahuytdtu.finalproject.controller;

import com.trangiahuytdtu.finalproject.entities.TypeOfReader;
import com.trangiahuytdtu.finalproject.service.TypeOfReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TypeOfReaderController {
    @Autowired
    TypeOfReaderService typeService;

//    @GetMapping("/reader/listTypeReader")
//    public String listAll(Model model){
//        List<TypeOfReader> listType = typeService.listAll();
//        model.addAttribute("listType", listType);
//        return "Reader/Register";
//    }
}

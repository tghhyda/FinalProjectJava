package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.service.TypeOfReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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

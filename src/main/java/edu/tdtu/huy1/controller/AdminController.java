package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.entities.TypeOfBook;
import edu.tdtu.huy1.entities.TypeOfReader;
import edu.tdtu.huy1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @Autowired
    ReaderService readerService;

    @Autowired
    BookService bookService;

    @Autowired
    TypeOfReaderService typeOfReaderService;

    @Autowired
    ProducerService producerService;

    @Autowired
    TypeOfBookService typeOfBookService;

    @GetMapping("/admin/login")
    public String viewAdminLogin(){
        return "Admin/AdminLogin";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(Model model){
        String keyword = "";
        model.addAttribute("listBooks", bookService.listAllBooks(keyword));
        model.addAttribute("listReaders", readerService.list4LatestReader());
        return "Admin/AdminHome";
    }

    @GetMapping("/admin/book")
    public String viewAdminBook(Model model, @Param("keyword") String keyword){
        model.addAttribute("listBooks", bookService.listAllBooks(keyword));
        model.addAttribute("keyword", keyword);
        return "Admin/AdminBook";
    }

    @GetMapping("/admin/reader")
    public String viewAdminReader(Model model, @Param("keyword") String keyword){
        model.addAttribute("listReaders", readerService.listAllReader(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("listType", typeOfReaderService.listAll(""));
        return "Admin/AdminReader";
    }

    @GetMapping("/admin/producer")
    public String viewAdminProducer(Model model, @Param("keyword") String keyword){
        model.addAttribute("listProducers", producerService.listAllProducer(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("newProducer", new Producer());

        return "Admin/AdminProducer";
    }

    @GetMapping("/admin/typereader")
    public String viewAdminTypeReader(Model model, @Param("keyword") String keyword){
        model.addAttribute("listType", typeOfReaderService.listAll(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("newType", new TypeOfReader());

        return "Admin/AdminTypeReader";
    }

    @GetMapping("/admin/typebook")
    public String viewAdminTypeBook(Model model, @Param("keyword") String keyword){
        model.addAttribute("listType", typeOfBookService.listAllTypeBook(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("newType", new TypeOfBook());

        return "Admin/AdminTypeBook";
    }
}
package com.trangiahuytdtu.finalproject.controller;


import com.trangiahuytdtu.finalproject.Exception.NotFoundException;
import com.trangiahuytdtu.finalproject.entities.Book;
import com.trangiahuytdtu.finalproject.entities.Producer;
import com.trangiahuytdtu.finalproject.entities.Reader;
import com.trangiahuytdtu.finalproject.entities.TypeOfBook;
import com.trangiahuytdtu.finalproject.service.BookService;
import com.trangiahuytdtu.finalproject.service.ProducerService;
import com.trangiahuytdtu.finalproject.service.TypeOfBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    TypeOfBookService typeBook;

    @Autowired
    ProducerService producerService;

    @GetMapping("/admin/book/add")
    public String viewAddNewBook(Model model){
        model.addAttribute("book", new Book());
        List<TypeOfBook> listType = typeBook.listAllTypeBook();
        List<Producer> listProducers = producerService.listAllProducer();
        model.addAttribute("listTypeBook", listType);
        model.addAttribute("listProducers", listProducers);
        return "Admin/Book/AddNewBook";
    }

    @PostMapping("admin/book/save")
    public String saveBook(@ModelAttribute(name = "book") Book book,
                    RedirectAttributes ra,
                    @RequestParam("photo")MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        book.setImg(fileName);
        Book savedBook = bookService.save(book);

        String uploadDir = "./book-images/" + savedBook.getIdBook();
        Path uploadPath = Paths.get(uploadDir);

        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Could not save uploaded file"+fileName);
        }


        ra.addFlashAttribute("message","Saved successfully");

        return "redirect:/admin/book";
    }

    @GetMapping("/admin/book/delete/{id}")
    public String deleteBook(@PathVariable("id") String id , RedirectAttributes ra){
        try {
            bookService.deleteBook(id);
            ra.addFlashAttribute("message","delete success");
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/book";
    }

    @GetMapping("admin/book/update/{id}")
    public String updateBook(@PathVariable("id") String id ,  Model model, RedirectAttributes ra){
        try{
            Book book = bookService.findById(id);
            model.addAttribute("book",book);

            List<TypeOfBook> listType = typeBook.listAllTypeBook();
            List<Producer> listProducers = producerService.listAllProducer();
            model.addAttribute("listTypeBook", listType);
            model.addAttribute("listProducers", listProducers);


            model.addAttribute("pageTitle", "Edit book (Id: " + id + ")");
            return "Admin/Book/UpdateBook";
        }catch (NotFoundException e){
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/admin/book";
        }
    }
}

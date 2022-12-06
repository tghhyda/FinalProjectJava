package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.Book;
import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.service.ProducerService;
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

@Controller
public class ProducerController {

    @Autowired
    ProducerService producerService;
    @PostMapping("admin/producer/save")
    public String saveProducer(Producer producer){
        producerService.save(producer);
        return "redirect:/admin/producer";
    }

    @GetMapping("/admin/producer/delete/{id}")
    public String deleteProducer(@PathVariable("id") String id , RedirectAttributes ra){
        try {
            producerService.deleteProducer(id);
            ra.addFlashAttribute("message","delete success");
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/producer";
    }

    @GetMapping("/admin/producer/update/{id}")
    public String findById(@PathVariable("id") String id, Model model){
        try {
            Producer producer = producerService.findById(id);
            model.addAttribute("producer", producer);
            model.addAttribute("pageTitle", "Edit Producer (Id: " + id + ")");
            return "Admin/Producer/UpdateProducer";
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.TypeOfBook;
import edu.tdtu.huy1.service.TypeOfBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class TypeOfBookController {
    @Autowired
    TypeOfBookService typeOfBookService;

    @PostMapping("admin/typebook/save")
    public String saveType(TypeOfBook typeOfBook){
        typeOfBookService.save(typeOfBook);
        return "redirect:/admin/typebook";
    }

    @GetMapping("/admin/typebook/delete/{id}")
    public String deleteType(@PathVariable("id") String id , RedirectAttributes ra){
        try {
            typeOfBookService.deleteTypeReader(id);
            ra.addFlashAttribute("message","delete success");
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/typebook";
    }

    @GetMapping("/admin/typebook/update/{id}")
    public String editType(Model model, @PathVariable("id") String id) throws NotFoundException {
        TypeOfBook typeOfBook = typeOfBookService.findById(id);
        model.addAttribute("typeOfBook", typeOfBook);
        model.addAttribute("pageTitle", "Update Type of Book: "+id);
        return "Admin/TypeBook/UpdateType";
    }
}

package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.TypeOfReader;
import edu.tdtu.huy1.service.TypeOfReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TypeOfReaderController {
    @Autowired
    TypeOfReaderService typeService;

    @PostMapping("admin/typereader/save")
    public String saveType(TypeOfReader typeOfReader){
        typeService.save(typeOfReader);
        return "redirect:/admin/typereader";
    }

    @GetMapping("/admin/typereader/delete/{id}")
    public String deleteType(@PathVariable("id") String id , RedirectAttributes ra){
        try {
            typeService.deleteTypeReader(id);
            ra.addFlashAttribute("message","delete success");
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/typereader";
    }

    @GetMapping("/admin/typereader/update/{id}")
    public String editType(Model model, @PathVariable("id") String id) throws NotFoundException {
        TypeOfReader typeOfReader = typeService.findById(id);
        model.addAttribute("typeOfReader", typeOfReader);
        model.addAttribute("pageTitle", "Update Type of Reader: "+id);
        return "Admin/TypeReader/UpdateType";
    }
}

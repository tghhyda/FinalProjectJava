package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.Loan;
import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping("reader/loan/save")
    public String saveLoan(Loan loan){
        loanService.save(loan);
        return "redirect:/reader/home";
    }

    @GetMapping("/admin/loan/delete/{id}")
    public String deleteProducer(@PathVariable("id") int id , RedirectAttributes ra){
        try {
            loanService.deleteLoan(id);
            ra.addFlashAttribute("message","delete success");
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/transaction";
    }
}

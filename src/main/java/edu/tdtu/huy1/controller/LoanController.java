package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.entities.Loan;
import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoanController {

    @Autowired
    LoanService loanService;

    @PostMapping("reader/loan/save")
    public String saveLoan(Loan loan){
        loanService.save(loan);
        return "redirect:/reader/home";
    }
}

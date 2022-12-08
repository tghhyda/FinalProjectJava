package edu.tdtu.huy1.service;

import edu.tdtu.huy1.entities.Loan;
import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;

    public Loan save(Loan loan){

        return loanRepository.save(loan);
    }
}

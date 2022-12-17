package edu.tdtu.huy1.service;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.Loan;
import edu.tdtu.huy1.entities.Reader;
import edu.tdtu.huy1.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;

    public Loan save(Loan loan){
        return loanRepository.save(loan);
    }

    public List<Loan> listAll(String keyword){
        if(keyword != null)
            return loanRepository.findAll(keyword);
        return (List<Loan>) loanRepository.findAll();
    }

    public void deleteLoan(int id) throws NotFoundException {
        Long count = loanRepository.countByIdLoan(id);
        if(count == null || count == 0){
            throw new NotFoundException("Could not find any transcation with id: "+ id);
        }
        loanRepository.deleteById(id);
    }

    public Loan findById(int id) throws NotFoundException {
        Optional<Loan> rs = loanRepository.findById(id);
        if(rs.isPresent()){
            return rs.get();
        }
        throw new NotFoundException("Could not find any loan with id: "+ id);
    }

    public List<Loan> listAllByReader(Optional<Reader> reader, String keyword){
        if(keyword != null){
            return loanRepository.findAllByReader(reader, keyword);
        }
        return loanRepository.findAllByReader(reader);
    }
}

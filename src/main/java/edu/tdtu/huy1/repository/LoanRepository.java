package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Loan;
import org.springframework.data.repository.CrudRepository;

public interface LoanRepository extends CrudRepository<Loan, Integer> {
}

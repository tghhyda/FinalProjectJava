package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Loan;
import edu.tdtu.huy1.entities.Reader;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends CrudRepository<Loan, Integer> {

    @Query("select l from Loan l where l.reader.nameReader like %?1%" +
            "or l.reader.idReader like %?1%")
    public List<Loan> findAll(String keyword);

    public List<Loan> findAllByReader(Optional<Reader> reader);

    public Long countByIdLoan(int id);
}

package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.entities.TypeOfBook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeOfBookRepository extends CrudRepository<TypeOfBook, String> {

    public Long countByIdType(String id);

    @Query("select p from TypeOfBook p where p.idType like %?1%" +
            "or p.nameType like %?1%" +
            "or p.note like %?1%")
    public List<TypeOfBook> findAll(String keyword);
}

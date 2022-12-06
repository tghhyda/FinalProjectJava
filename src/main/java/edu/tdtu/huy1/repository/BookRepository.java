package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {
    public Long countByIdBook(String id);

    @Query("select b from Book b where b.author like %?1%" +
            " or b.idBook like %?1%" +
            " or b.nameBook like %?1%" +
            "or b.typeOfBook.nameType like %?1%")
    public List<Book> findAll(String keyword);
}

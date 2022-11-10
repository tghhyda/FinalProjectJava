package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
    public Long countByIdBook(String id);
}

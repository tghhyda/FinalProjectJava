package com.trangiahuytdtu.finalproject.repository;

import com.trangiahuytdtu.finalproject.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
    public Long countByIdBook(String id);
}

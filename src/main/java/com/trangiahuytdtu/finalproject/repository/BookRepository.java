package com.trangiahuytdtu.finalproject.repository;

import com.trangiahuytdtu.finalproject.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}

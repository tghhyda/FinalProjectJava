package com.trangiahuytdtu.finalproject.service;

import com.trangiahuytdtu.finalproject.entities.Book;
import com.trangiahuytdtu.finalproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> listAllBooks(){
        return (List<Book>) bookRepository.findAll();
    }
}

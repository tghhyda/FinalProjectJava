package com.trangiahuytdtu.finalproject.service;

import com.trangiahuytdtu.finalproject.entities.Book;
import com.trangiahuytdtu.finalproject.entities.Reader;
import com.trangiahuytdtu.finalproject.entities.Role;
import com.trangiahuytdtu.finalproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book save(Book book){
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        String currentTime = formatter.format(new Date());
        book.setIdBook("Book"+currentTime);

        return bookRepository.save(book);
    }

    public List<Book> listAllBooks(){
        return (List<Book>) bookRepository.findAll();
    }
}

package com.trangiahuytdtu.finalproject.service;

import com.trangiahuytdtu.finalproject.Exception.NotFoundException;
import com.trangiahuytdtu.finalproject.entities.Book;
import com.trangiahuytdtu.finalproject.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book save(Book book){
        if(book.getIdBook() == null){
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
            String currentTime = formatter.format(new Date());
            book.setIdBook("Book"+currentTime);
        }
        return bookRepository.save(book);
    }

    public List<Book> listAllBooks(){
        return (List<Book>) bookRepository.findAll();
    }

    public void deleteBook(String id) throws NotFoundException {
        Long count = bookRepository.countByIdBook(id);
        if(count == null || count == 0){
            throw new NotFoundException("Could not find any book with id: "+ id);
        }
        bookRepository.deleteById(id);
    }

    public Book findById(String id) throws NotFoundException {
        Optional<Book> rs = bookRepository.findById(id);
        if(rs.isPresent()){
            return rs.get();
        }
        throw new NotFoundException("Could not find any book with id: "+ id);
    }
}

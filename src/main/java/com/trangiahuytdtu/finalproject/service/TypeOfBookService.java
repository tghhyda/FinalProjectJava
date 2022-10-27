package com.trangiahuytdtu.finalproject.service;

import com.trangiahuytdtu.finalproject.entities.TypeOfBook;
import com.trangiahuytdtu.finalproject.repository.TypeOfBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfBookService {
    @Autowired
    TypeOfBookRepository typeBook;

    public List<TypeOfBook> listAllTypeBook(){
        return (List<TypeOfBook>) typeBook.findAll();
    }
}

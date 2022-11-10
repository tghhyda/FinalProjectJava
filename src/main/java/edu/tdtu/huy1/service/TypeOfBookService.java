package edu.tdtu.huy1.service;

import edu.tdtu.huy1.entities.TypeOfBook;
import edu.tdtu.huy1.repository.TypeOfBookRepository;
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

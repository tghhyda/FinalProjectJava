package edu.tdtu.huy1.service;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.TypeOfBook;
import edu.tdtu.huy1.entities.TypeOfReader;
import edu.tdtu.huy1.repository.TypeOfBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TypeOfBookService {
    @Autowired
    TypeOfBookRepository typeBook;

    public List<TypeOfBook> listAllTypeBook(String keyword){
        if(keyword != null){
            return typeBook.findAll(keyword);
        }
        return (List<TypeOfBook>) typeBook.findAll();
    }

    public TypeOfBook save(TypeOfBook typeOfBook){
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        String currentTime = formatter.format(new Date());
        typeOfBook.setIdType("TOB"+currentTime);
        return typeBook.save(typeOfBook);
    }
    public void deleteTypeReader(String id) throws NotFoundException {
        Long count = typeBook.countByIdType(id);
        if(count == null || count == 0){
            throw new NotFoundException("Could not find any type with id: "+ id);
        }
        typeBook.deleteById(id);
    }
}

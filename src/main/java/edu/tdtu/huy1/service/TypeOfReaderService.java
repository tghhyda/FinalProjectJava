package edu.tdtu.huy1.service;

import edu.tdtu.huy1.entities.TypeOfReader;
import edu.tdtu.huy1.repository.TypeOfReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfReaderService {
    @Autowired
    private TypeOfReaderRepository typeRepo;

    public List<TypeOfReader> listAll(){
        return (List<TypeOfReader>) typeRepo.findAll();
    }
}

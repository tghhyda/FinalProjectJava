package com.trangiahuytdtu.finalproject.service;

import com.trangiahuytdtu.finalproject.entities.TypeOfReader;
import com.trangiahuytdtu.finalproject.repository.TypeOfReaderRepository;
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

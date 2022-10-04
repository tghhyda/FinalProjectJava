package com.trangiahuytdtu.finalproject.repository;

import com.trangiahuytdtu.finalproject.entities.Reader;
import com.trangiahuytdtu.finalproject.entities.TypeOfReader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeOfReaderRepository extends CrudRepository<TypeOfReader, String> {
    public TypeOfReader findByName(String name);
}

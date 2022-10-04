package com.trangiahuytdtu.finalproject.repository;

import com.trangiahuytdtu.finalproject.entities.Reader;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReaderRepository extends CrudRepository<Reader, String> {
    public Reader findByEmail(String email);
}

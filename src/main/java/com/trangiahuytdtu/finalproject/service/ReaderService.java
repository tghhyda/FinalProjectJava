package com.trangiahuytdtu.finalproject.service;

import com.trangiahuytdtu.finalproject.entities.Reader;
import com.trangiahuytdtu.finalproject.entities.Role;
import com.trangiahuytdtu.finalproject.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ReaderService{
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void encodePassword(Reader reader){
        String encodePassword = passwordEncoder.encode(reader.getPassword());
        reader.setPassword(encodePassword);
    }

    public Reader save(Reader reader){
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        String currentTime = formatter.format(new Date());
        reader.setIdReader("Reader"+currentTime);
        encodePassword(reader);
        reader.setRole(Role.READER);

        return readerRepository.save(reader);
    }

    public List<Reader> listAllReader(){
        List<Reader> readers = new ArrayList<>();
        for(Reader reader : readerRepository.findAll()){
            if(reader.getRole() == Role.READER)
                readers.add(reader);
        }
        return readers;
    }
}

package com.trangiahuytdtu.finalproject.service;

import com.trangiahuytdtu.finalproject.entities.Producer;
import com.trangiahuytdtu.finalproject.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    @Autowired
    ProducerRepository producerRepository;
    public List<Producer> listAllProducer(){
        return (List<Producer>) producerRepository.findAll();
    }
}

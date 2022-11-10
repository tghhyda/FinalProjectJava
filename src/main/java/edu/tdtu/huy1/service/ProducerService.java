package edu.tdtu.huy1.service;

import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.repository.ProducerRepository;
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

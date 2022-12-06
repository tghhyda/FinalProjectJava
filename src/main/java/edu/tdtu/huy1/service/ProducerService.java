package edu.tdtu.huy1.service;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProducerService {
    @Autowired
    ProducerRepository producerRepository;
    public List<Producer> listAllProducer(String keyword){
        if(keyword != null){
            return producerRepository.findAll(keyword);
        }
        return (List<Producer>) producerRepository.findAll();
    }

    public Producer save(Producer producer){
        if(producer.getIdProducer() == null){
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
            String currentTime = formatter.format(new Date());
            producer.setIdProducer("PRODUCER"+currentTime);
        }
        return producerRepository.save(producer);
    }

    public void deleteProducer(String id) throws NotFoundException {
        Long count = producerRepository.countByIdProducer(id);
        if(count == null || count == 0){
            throw new NotFoundException("Could not find any producer with id: "+ id);
        }
        producerRepository.deleteById(id);
    }

    public Producer findById(String id) throws NotFoundException {
        Optional<Producer> rs = producerRepository.findById(id);
        if(rs.isPresent()){
            return rs.get();
        }
        throw new NotFoundException("Could not find any book with id: "+ id);
    }
}

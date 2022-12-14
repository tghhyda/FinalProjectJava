package edu.tdtu.huy1.service;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.TypeOfReader;
import edu.tdtu.huy1.repository.TypeOfReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TypeOfReaderService {
    @Autowired
    private TypeOfReaderRepository typeRepo;

    public List<TypeOfReader> listAll(String keyword){
        if(keyword != null){
            return  typeRepo.findAll(keyword);
        }
        return (List<TypeOfReader>) typeRepo.findAll();
    }

    public TypeOfReader save(TypeOfReader typeOfReader){
        if(typeOfReader.getIdType() == null){
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
            String currentTime = formatter.format(new Date());
            typeOfReader.setIdType("TOD"+currentTime);
        }
        return typeRepo.save(typeOfReader);
    }

    public void deleteTypeReader(String id) throws NotFoundException {
        Long count = typeRepo.countByIdType(id);
        if(count == null || count == 0){
            throw new NotFoundException("Could not find any type with id: "+ id);
        }
        typeRepo.deleteById(id);
    }

    public TypeOfReader findById(String id) throws NotFoundException {
        Optional<TypeOfReader> rs =  typeRepo.findById(id);
        if(rs.isPresent()){
            return rs.get();
        }
        throw new NotFoundException("Could not find any book with id: "+ id);
    }
}

package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.TypeOfReader;
import org.springframework.data.repository.CrudRepository;

public interface TypeOfReaderRepository extends CrudRepository<TypeOfReader, String> {
    public TypeOfReader findByName(String name);
}

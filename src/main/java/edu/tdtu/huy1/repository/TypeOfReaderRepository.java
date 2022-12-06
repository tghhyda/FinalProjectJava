package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.entities.TypeOfReader;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeOfReaderRepository extends CrudRepository<TypeOfReader, String> {
    public TypeOfReader findByName(String name);
    public Long countByIdType(String id);

    @Query("select p from TypeOfReader p where p.idType like %?1%" +
            "or p.name like %?1%" +
            "or p.note like %?1%")
    public List<TypeOfReader> findAll(String keyword);
}

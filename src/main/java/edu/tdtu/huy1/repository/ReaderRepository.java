package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Reader;
import edu.tdtu.huy1.entities.TypeOfReader;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReaderRepository extends CrudRepository<Reader, String> {
    public Reader findByEmail(String email);
    public Long countByIdReader(String id);
    @Query("select r from Reader r where r.idReader like %?1%" +
            "or r.nameReader like %?1%" +
            "or r.gender like %?1%" +
            "or r.email like %?1%" +
            "or r.phone like %?1%")
    public List<Reader> findAll(String keyword);
}

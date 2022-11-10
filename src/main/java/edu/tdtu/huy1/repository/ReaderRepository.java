package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Reader;
import org.springframework.data.repository.CrudRepository;

public interface ReaderRepository extends CrudRepository<Reader, String> {
    public Reader findByEmail(String email);
    public Long countByIdReader(String id);
}

package edu.tdtu.huy1.repository;

import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.entities.Reader;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProducerRepository extends CrudRepository<Producer, String> {
    public Long countByIdProducer(String id);

    @Query("select p from Producer p where p.idProducer like %?1%" +
            "or p.nameProducer like %?1%" +
            "or p.phoneProducer like %?1%" +
            "or p.addressProducer like %?1%")
    public List<Producer> findAll(String keyword);
}

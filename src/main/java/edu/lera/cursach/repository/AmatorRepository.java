package edu.lera.cursach.repository;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AmatorRepository extends MongoRepository<Amator, String> {
    List<Amator> findByTourist_Name(String name);

}

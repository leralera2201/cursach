package edu.lera.cursach.repository;

import edu.lera.cursach.model.Sportsman;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SportsmanRepository extends MongoRepository<Sportsman, String> {
    List<Sportsman> findByTourist_Name(String name);
}

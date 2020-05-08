package edu.lera.cursach.repository;

import edu.lera.cursach.model.Tour;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TourRepository extends MongoRepository<Tour, String> {

    List<Tour> findByTourName(String name);
}

package edu.lera.cursach.repository;

import edu.lera.cursach.model.TourType;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TourTypeRepository extends MongoRepository<TourType, String> {
    List<TourType> findByTypeName(String name);
}

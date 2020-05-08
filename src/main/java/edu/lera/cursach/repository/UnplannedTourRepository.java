package edu.lera.cursach.repository;

import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.model.UnplannedTour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UnplannedTourRepository extends MongoRepository<UnplannedTour, String> {
    List<UnplannedTour> findByTour_TourName(String name);
}

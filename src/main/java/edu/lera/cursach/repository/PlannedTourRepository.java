package edu.lera.cursach.repository;

import edu.lera.cursach.model.PlannedTour;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlannedTourRepository extends MongoRepository<PlannedTour, String> {
    List<PlannedTour> findByTour_TourName(String name);
}

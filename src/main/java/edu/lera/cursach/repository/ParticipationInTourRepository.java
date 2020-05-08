package edu.lera.cursach.repository;

import edu.lera.cursach.model.ParticipationInTour;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ParticipationInTourRepository extends MongoRepository<ParticipationInTour, String> {
    List<ParticipationInTour> findByTourist_Name(String name);
    List<ParticipationInTour> findByTour_TourName(String name);
}

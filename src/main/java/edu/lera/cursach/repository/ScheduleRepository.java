package edu.lera.cursach.repository;

import edu.lera.cursach.model.Schedule;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {
    List<Schedule> findByTrainName(String name);
}

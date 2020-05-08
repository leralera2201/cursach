package edu.lera.cursach.repository;

import edu.lera.cursach.model.Coach;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface CoachRepository extends MongoRepository<Coach, String> {
//    List<Coach> findByTourist_Sex(boolean sex);
//    List<Coach> findBySpecialityContains(String speciality);
//    List<Coach> findBySalaryGreaterThanEqual(double salary);
//    List<Coach> findBySalaryLessThanEqual(double salary);
//    List<Coach> findByTourist_Birthday(LocalDate birthday);
    List<Coach> findByTourist_Name(String name);
}

package edu.lera.cursach.repository;

import edu.lera.cursach.model.Captain;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface CaptainRepository extends MongoRepository<Captain, String> {
//    List<Captain> findBySalaryGreaterThanEqual(double salary);
//    List<Captain> findBySalaryLessThanEqual(double salary);
//    List<Captain> findByStarted_work_yearEquals(int year);
//    List<Captain> findByBirthdayEquals(int year);
        List<Captain> findByName(String name);
}

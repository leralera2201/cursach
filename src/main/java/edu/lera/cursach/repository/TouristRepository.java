package edu.lera.cursach.repository;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TouristRepository extends MongoRepository<Tourist, String> {
//    List<Tourist> findByMarkGreaterThanEqual(int mark);
//    List<Tourist> findBySexEquals(boolean sex);
//    List<Tourist> findByBirthdayEquals(int year);
        List<Tourist> findByName(String name);

}

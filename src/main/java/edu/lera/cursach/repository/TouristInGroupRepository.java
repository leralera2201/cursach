package edu.lera.cursach.repository;

import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.model.TouristInGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TouristInGroupRepository extends MongoRepository<TouristInGroup, String> {
    List<TouristInGroup> findByTourist_Name(String name);
    List<TouristInGroup> findByGroup_GroupName(String name);

}

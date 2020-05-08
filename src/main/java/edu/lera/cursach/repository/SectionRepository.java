package edu.lera.cursach.repository;

import edu.lera.cursach.model.Section;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SectionRepository extends MongoRepository<Section, String> {
    List<Section> findBySectionName(String name);
}

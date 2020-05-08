package edu.lera.cursach.repository;

import edu.lera.cursach.model.Competition;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompetitionRepository extends MongoRepository<Competition, String> {
//    List<Competition> findBySection_Section_name(String section_name);
    List<Competition> findByCompetitionName(String name);
}

package edu.lera.cursach.repository;

import edu.lera.cursach.model.ParticipationInCompetition;
import edu.lera.cursach.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ParticipationInCompetitionRepository extends MongoRepository<ParticipationInCompetition, String> {
    List<ParticipationInCompetition> findByCompetition_CompetitionName(String name);
    List<ParticipationInCompetition> findByTourist_Name(String name);
}

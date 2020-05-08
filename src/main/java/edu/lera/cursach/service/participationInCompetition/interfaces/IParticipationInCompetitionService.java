package edu.lera.cursach.service.participationInCompetition.interfaces;

import edu.lera.cursach.model.ParticipationInCompetition;

import java.util.List;

public interface IParticipationInCompetitionService {
    ParticipationInCompetition save(ParticipationInCompetition participationInCompetition);
    ParticipationInCompetition get(String id);
    List<ParticipationInCompetition> getAll();
    ParticipationInCompetition edit(ParticipationInCompetition participationInCompetition);
    ParticipationInCompetition delete(String id);

    ParticipationInCompetition getByTouristName(String name);
    List<ParticipationInCompetition> getAllByTouristName(String name);
    ParticipationInCompetition getByCompetitionName(String name);
    List<ParticipationInCompetition> getAllByCompetitionName(String name);
}

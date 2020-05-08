package edu.lera.cursach.dao.participationInCompetition.interfaces;

import java.util.List;

public interface IParticipationInCompetitionDao {
    edu.lera.cursach.model.ParticipationInCompetition save(edu.lera.cursach.model.ParticipationInCompetition participationInCompetition);
    edu.lera.cursach.model.ParticipationInCompetition get(String id);
    List<edu.lera.cursach.model.ParticipationInCompetition> getAll();
    edu.lera.cursach.model.ParticipationInCompetition edit(edu.lera.cursach.model.ParticipationInCompetition participationInCompetition);
    edu.lera.cursach.model.ParticipationInCompetition delete(String id);
}

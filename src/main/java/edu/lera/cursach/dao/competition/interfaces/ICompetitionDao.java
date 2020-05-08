package edu.lera.cursach.dao.competition.interfaces;

import java.util.List;

public interface ICompetitionDao {
    edu.lera.cursach.model.Competition save(edu.lera.cursach.model.Competition competition);
    edu.lera.cursach.model.Competition get(String id);
    List<edu.lera.cursach.model.Competition> getAll();
    edu.lera.cursach.model.Competition edit(edu.lera.cursach.model.Competition competition);
    edu.lera.cursach.model.Competition delete(String id);
}

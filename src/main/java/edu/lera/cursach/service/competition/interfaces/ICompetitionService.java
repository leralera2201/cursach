package edu.lera.cursach.service.competition.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Competition;

import java.util.List;

public interface ICompetitionService {
    Competition save(Competition competition);
    Competition get(String id);
    List<Competition> getAll();
    Competition edit(Competition competition);
    Competition delete(String id);

    Competition getByName(String name);
    List<Competition> getAllByName(String name);
}

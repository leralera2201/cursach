package edu.lera.cursach.service.coach.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Coach;

import java.util.List;

public interface ICoachService {
    Coach save(Coach coach);
    Coach get(String id);
    List<Coach> getAll();
    Coach edit(Coach coach);
    Coach delete(String id);
    Coach getByName(String name);
    List<Coach> getAllByName(String name);
}

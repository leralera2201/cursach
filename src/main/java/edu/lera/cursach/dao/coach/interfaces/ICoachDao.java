package edu.lera.cursach.dao.coach.interfaces;

import java.util.List;

public interface ICoachDao {
    edu.lera.cursach.model.Coach save(edu.lera.cursach.model.Coach coach);
    edu.lera.cursach.model.Coach get(String id);
    List<edu.lera.cursach.model.Coach> getAll();
    edu.lera.cursach.model.Coach edit(edu.lera.cursach.model.Coach coach);
    edu.lera.cursach.model.Coach delete(String id);
}

package edu.lera.cursach.dao.schedule.interfaces;

import java.util.List;

public interface IScheduleDao {
    edu.lera.cursach.model.Schedule save(edu.lera.cursach.model.Schedule schedule);
    edu.lera.cursach.model.Schedule get(String id);
    List<edu.lera.cursach.model.Schedule> getAll();
    edu.lera.cursach.model.Schedule edit(edu.lera.cursach.model.Schedule schedule);
    edu.lera.cursach.model.Schedule delete(String id);
}

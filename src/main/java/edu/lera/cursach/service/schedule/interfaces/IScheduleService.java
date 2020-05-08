package edu.lera.cursach.service.schedule.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Schedule;

import java.util.List;

public interface IScheduleService {
    Schedule save(Schedule schedule);
    Schedule get(String id);
    List<Schedule> getAll();
    Schedule edit(Schedule schedule);
    Schedule delete(String id);
    Schedule getByName(String name);
    List<Schedule> getAllByName(String name);
}

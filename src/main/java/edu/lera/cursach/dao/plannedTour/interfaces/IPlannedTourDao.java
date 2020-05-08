package edu.lera.cursach.dao.plannedTour.interfaces;

import java.util.List;

public interface IPlannedTourDao {
    edu.lera.cursach.model.PlannedTour save(edu.lera.cursach.model.PlannedTour plannedTour);
    edu.lera.cursach.model.PlannedTour get(String id);
    List<edu.lera.cursach.model.PlannedTour> getAll();
    edu.lera.cursach.model.PlannedTour edit(edu.lera.cursach.model.PlannedTour plannedTour);
    edu.lera.cursach.model.PlannedTour delete(String id);
}

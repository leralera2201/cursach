package edu.lera.cursach.service.plannedTour.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.PlannedTour;

import java.util.List;

public interface IPlannedTourService {
    PlannedTour save(PlannedTour plannedTour);
    PlannedTour get(String id);
    List<PlannedTour> getAll();
    PlannedTour edit(PlannedTour plannedTour);
    PlannedTour delete(String id);

    PlannedTour getByName(String name);
    List<PlannedTour> getAllByName(String name);
}

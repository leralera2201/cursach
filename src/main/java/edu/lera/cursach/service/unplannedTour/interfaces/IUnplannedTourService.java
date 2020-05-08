package edu.lera.cursach.service.unplannedTour.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.UnplannedTour;

import java.util.List;

public interface IUnplannedTourService {
    UnplannedTour save(UnplannedTour unplannedTour);
    UnplannedTour get(String id);
    List<UnplannedTour> getAll();
    UnplannedTour edit(UnplannedTour unplannedTour);
    UnplannedTour delete(String id);
    UnplannedTour getByName(String name);
    List<UnplannedTour> getAllByName(String name);

}

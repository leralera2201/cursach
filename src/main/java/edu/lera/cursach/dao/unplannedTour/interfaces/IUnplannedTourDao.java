package edu.lera.cursach.dao.unplannedTour.interfaces;

import java.util.List;

public interface IUnplannedTourDao {
    edu.lera.cursach.model.UnplannedTour save(edu.lera.cursach.model.UnplannedTour unplannedTour);
    edu.lera.cursach.model.UnplannedTour get(String id);
    List<edu.lera.cursach.model.UnplannedTour> getAll();
    edu.lera.cursach.model.UnplannedTour edit(edu.lera.cursach.model.UnplannedTour unplannedTour);
    edu.lera.cursach.model.UnplannedTour delete(String id);
}

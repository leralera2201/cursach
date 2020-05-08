package edu.lera.cursach.service.tour.interfaces;

import edu.lera.cursach.model.Tour;

import java.util.List;

public interface ITourService {
    Tour save(Tour tour);
    Tour get(String id);
    List<Tour> getAll();
    Tour edit(Tour tour);
    Tour delete(String id);

    Tour getByName(String name);
    List<Tour> getAllByName(String name);
}

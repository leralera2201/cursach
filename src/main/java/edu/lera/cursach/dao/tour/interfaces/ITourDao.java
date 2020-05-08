package edu.lera.cursach.dao.tour.interfaces;

import java.util.List;

public interface ITourDao {
    edu.lera.cursach.model.Tour save(edu.lera.cursach.model.Tour tour);
    edu.lera.cursach.model.Tour get(String id);
    List<edu.lera.cursach.model.Tour> getAll();
    edu.lera.cursach.model.Tour edit(edu.lera.cursach.model.Tour tour);
    edu.lera.cursach.model.Tour delete(String id);
}

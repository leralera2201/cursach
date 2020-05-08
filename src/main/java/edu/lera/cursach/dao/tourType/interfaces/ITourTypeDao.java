package edu.lera.cursach.dao.tourType.interfaces;

import java.util.List;

public interface ITourTypeDao {
    edu.lera.cursach.model.TourType save(edu.lera.cursach.model.TourType tourType);
    edu.lera.cursach.model.TourType get(String id);
    List<edu.lera.cursach.model.TourType> getAll();
    edu.lera.cursach.model.TourType edit(edu.lera.cursach.model.TourType tourType);
    edu.lera.cursach.model.TourType delete(String id);
}

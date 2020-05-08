package edu.lera.cursach.service.tourType.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.TourType;

import java.util.List;

public interface ITouristService {
    TourType save(TourType tourType);
    TourType get(String id);
    List<TourType> getAll();
    TourType edit(TourType tourType);
    TourType delete(String id);
    TourType getByName(String name);
    List<TourType> getAllByName(String name);
}

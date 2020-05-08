package edu.lera.cursach.service.touristInGroup.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.TouristInGroup;

import java.util.List;

public interface ITouristInGroupService {
    TouristInGroup save(TouristInGroup touristInGroup);
    TouristInGroup get(String id);
    List<TouristInGroup> getAll();
    TouristInGroup edit(TouristInGroup touristInGroup);
    TouristInGroup delete(String id);

    TouristInGroup getByGroupName(String name);
    List<TouristInGroup> getAllByGroupName(String name);
    TouristInGroup getByTouristName(String name);
    List<TouristInGroup> getAllByTouristName(String name);
}

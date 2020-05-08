package edu.lera.cursach.dao.touristInGroup.interfaces;

import java.util.List;

public interface ITouristInGroupDao {
    edu.lera.cursach.model.TouristInGroup save(edu.lera.cursach.model.TouristInGroup touristInGroup);
    edu.lera.cursach.model.TouristInGroup get(String id);
    List<edu.lera.cursach.model.TouristInGroup> getAll();
    edu.lera.cursach.model.TouristInGroup edit(edu.lera.cursach.model.TouristInGroup touristInGroup);
    edu.lera.cursach.model.TouristInGroup delete(String id);
}

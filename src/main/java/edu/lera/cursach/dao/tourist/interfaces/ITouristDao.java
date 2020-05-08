package edu.lera.cursach.dao.tourist.interfaces;

import java.util.List;

public interface ITouristDao {
    edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist);
    edu.lera.cursach.model.Tourist get(String id);
    List<edu.lera.cursach.model.Tourist> getAll();
    edu.lera.cursach.model.Tourist edit(edu.lera.cursach.model.Tourist tourist);
    edu.lera.cursach.model.Tourist delete(String id);
}

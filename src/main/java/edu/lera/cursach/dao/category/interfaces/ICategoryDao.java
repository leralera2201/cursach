package edu.lera.cursach.dao.category.interfaces;

import java.util.List;

public interface ICategoryDao {
    edu.lera.cursach.model.Category save(edu.lera.cursach.model.Category category);
    edu.lera.cursach.model.Category get(String id);
    List<edu.lera.cursach.model.Category> getAll();
    edu.lera.cursach.model.Category edit(edu.lera.cursach.model.Category category);
    edu.lera.cursach.model.Category delete(String id);
}

package edu.lera.cursach.service.category.interfaces;

import edu.lera.cursach.model.Category;

import java.util.List;

public interface ICategoryService {
    Category save(Category category);
    Category get(String id);
    List<Category> getAll();
    Category edit(Category category);
    Category delete(String id);

    Category getByName(String name);
    List<Category> getAllByName(String name);
}

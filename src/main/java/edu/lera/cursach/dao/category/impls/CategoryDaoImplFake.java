package edu.lera.cursach.dao.category.impls;

import edu.lera.cursach.dao.category.interfaces.ICategoryDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDaoImplFake implements ICategoryDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Category save(edu.lera.cursach.model.Category category) {
//        dataSet.getCategories().add(category);
//        return category;
//    }
    @Override
    public edu.lera.cursach.model.Category save(edu.lera.cursach.model.Category category) {
      return null;
    }
    @Override
    public edu.lera.cursach.model.Category get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Category> getAll() {
        return dataSet.getCategories();
    }

    @Override
    public edu.lera.cursach.model.Category edit(edu.lera.cursach.model.Category category) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Category delete(String id) {
        return null;
    }
}

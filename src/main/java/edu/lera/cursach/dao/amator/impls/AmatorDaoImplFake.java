package edu.lera.cursach.dao.amator.impls;

import edu.lera.cursach.dao.amator.interfaces.IAmatorDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AmatorDaoImplFake implements IAmatorDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Category save(edu.lera.cursach.model.Category category) {
//        dataSet.getCategories().add(category);
//        return category;
//    }
    @Override
    public edu.lera.cursach.model.Amator save(edu.lera.cursach.model.Amator amator) {
      return null;
    }
    @Override
    public edu.lera.cursach.model.Amator get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Amator> getAll() {
        return dataSet.getAmators();
    }

    @Override
    public edu.lera.cursach.model.Amator edit(edu.lera.cursach.model.Amator amator) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Amator delete(String id) {
        return null;
    }
}

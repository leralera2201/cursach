package edu.lera.cursach.dao.tourist.impls;

import edu.lera.cursach.dao.tourist.interfaces.ITouristDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TouristDaoImplFake implements ITouristDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Tourist get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Tourist> getAll() {
        return dataSet.getTourists();
    }

    @Override
    public edu.lera.cursach.model.Tourist edit(edu.lera.cursach.model.Tourist tourist) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Tourist delete(String id) {
        return null;
    }
}

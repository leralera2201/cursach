package edu.lera.cursach.dao.sportsman.impls;

import edu.lera.cursach.dao.sportsman.interfaces.ISportsmanDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SportsmanDaoImplFake implements ISportsmanDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.Sportsman save(edu.lera.cursach.model.Sportsman sportsman) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Sportsman get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Sportsman> getAll() {
        return dataSet.getSportsmen();
    }

    @Override
    public edu.lera.cursach.model.Sportsman edit(edu.lera.cursach.model.Sportsman sportsman) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Sportsman delete(String id) {
        return null;
    }
}

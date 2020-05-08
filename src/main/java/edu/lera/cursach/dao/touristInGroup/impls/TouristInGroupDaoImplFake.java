package edu.lera.cursach.dao.touristInGroup.impls;

import edu.lera.cursach.dao.touristInGroup.interfaces.ITouristInGroupDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TouristInGroupDaoImplFake implements ITouristInGroupDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.TouristInGroup save(edu.lera.cursach.model.TouristInGroup touristInGroup) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.TouristInGroup get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.TouristInGroup> getAll() {
        return dataSet.getTouristInGroups();
    }

    @Override
    public edu.lera.cursach.model.TouristInGroup edit(edu.lera.cursach.model.TouristInGroup touristInGroup) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.TouristInGroup delete(String id) {
        return null;
    }
}

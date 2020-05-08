package edu.lera.cursach.dao.tourType.impls;

import edu.lera.cursach.dao.tourType.interfaces.ITourTypeDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TourTypeDaoImplFake implements ITourTypeDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.TourType save(edu.lera.cursach.model.TourType tourType) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.TourType get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.TourType> getAll() {
        return dataSet.getTourTypes();
    }

    @Override
    public edu.lera.cursach.model.TourType edit(edu.lera.cursach.model.TourType tourType) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.TourType delete(String id) {
        return null;
    }
}

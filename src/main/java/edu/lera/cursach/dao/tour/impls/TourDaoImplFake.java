package edu.lera.cursach.dao.tour.impls;

import edu.lera.cursach.dao.tour.interfaces.ITourDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TourDaoImplFake implements ITourDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.Tour save(edu.lera.cursach.model.Tour tour) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Tour get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Tour> getAll() {
        return dataSet.getTours();
    }

    @Override
    public edu.lera.cursach.model.Tour edit(edu.lera.cursach.model.Tour tour) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Tour delete(String id) {
        return null;
    }
}

package edu.lera.cursach.dao.unplannedTour.impls;

import edu.lera.cursach.dao.unplannedTour.interfaces.IUnplannedTourDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UnplannedTourDaoImplFake implements IUnplannedTourDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.UnplannedTour save(edu.lera.cursach.model.UnplannedTour unplannedTour) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.UnplannedTour get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.UnplannedTour> getAll() {
        return dataSet.getUnplannedTours();
    }

    @Override
    public edu.lera.cursach.model.UnplannedTour edit(edu.lera.cursach.model.UnplannedTour unplannedTour) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.UnplannedTour delete(String id) {
        return null;
    }
}

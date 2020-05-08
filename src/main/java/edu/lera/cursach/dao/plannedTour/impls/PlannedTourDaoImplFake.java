package edu.lera.cursach.dao.plannedTour.impls;

import edu.lera.cursach.dao.plannedTour.interfaces.IPlannedTourDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlannedTourDaoImplFake implements IPlannedTourDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.PlannedTour save(edu.lera.cursach.model.PlannedTour plannedTour) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.PlannedTour get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.PlannedTour> getAll() {
        return dataSet.getPlannedTours();
    }

    @Override
    public edu.lera.cursach.model.PlannedTour edit(edu.lera.cursach.model.PlannedTour plannedTour) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.PlannedTour delete(String id) {
        return null;
    }
}

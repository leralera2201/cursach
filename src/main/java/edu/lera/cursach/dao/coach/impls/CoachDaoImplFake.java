package edu.lera.cursach.dao.coach.impls;

import edu.lera.cursach.dao.coach.interfaces.ICoachDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoachDaoImplFake implements ICoachDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.Coach save(edu.lera.cursach.model.Coach coach) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Coach get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Coach> getAll() {
        return dataSet.getCoaches();
    }

    @Override
    public edu.lera.cursach.model.Coach edit(edu.lera.cursach.model.Coach coach) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Coach delete(String id) {
        return null;
    }
}

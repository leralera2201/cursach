package edu.lera.cursach.dao.schedule.impls;

import edu.lera.cursach.dao.schedule.interfaces.IScheduleDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleDaoImplFake implements IScheduleDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.Schedule save(edu.lera.cursach.model.Schedule schedule) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Schedule get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Schedule> getAll() {
        return dataSet.getSchedules();
    }

    @Override
    public edu.lera.cursach.model.Schedule edit(edu.lera.cursach.model.Schedule schedule) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Schedule delete(String id) {
        return null;
    }
}

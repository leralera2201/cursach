package edu.lera.cursach.dao.captain.impls;

import edu.lera.cursach.dao.captain.interfaces.ICaptainDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaptainDaoImplFake implements ICaptainDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.Captain save(edu.lera.cursach.model.Captain captain) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Captain get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Captain> getAll() {
        return dataSet.getCaptains();
    }

    @Override
    public edu.lera.cursach.model.Captain edit(edu.lera.cursach.model.Captain captain) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Captain delete(String id) {
        return null;
    }
}

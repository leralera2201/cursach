package edu.lera.cursach.dao.section.impls;

import edu.lera.cursach.dao.section.interfaces.ISectionDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SectionDaoImplFake implements ISectionDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.Section save(edu.lera.cursach.model.Section section) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Section get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Section> getAll() {
        return dataSet.getSections();
    }

    @Override
    public edu.lera.cursach.model.Section edit(edu.lera.cursach.model.Section section) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Section delete(String id) {
        return null;
    }
}

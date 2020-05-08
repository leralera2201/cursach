package edu.lera.cursach.dao.amator.interfaces;

import java.util.List;

public interface IAmatorDao {
    edu.lera.cursach.model.Amator save(edu.lera.cursach.model.Amator amator);
    edu.lera.cursach.model.Amator get(String id);
    List<edu.lera.cursach.model.Amator> getAll();
    edu.lera.cursach.model.Amator edit(edu.lera.cursach.model.Amator amator);
    edu.lera.cursach.model.Amator delete(String id);
}

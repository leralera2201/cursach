package edu.lera.cursach.dao.group.interfaces;

import java.util.List;

public interface IGroupDao {
    edu.lera.cursach.model.Group save(edu.lera.cursach.model.Group group);
    edu.lera.cursach.model.Group get(String id);
    List<edu.lera.cursach.model.Group> getAll();
    edu.lera.cursach.model.Group edit(edu.lera.cursach.model.Group group);
    edu.lera.cursach.model.Group delete(String id);
}

package edu.lera.cursach.service.group.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Group;

import java.util.List;

public interface IGroupService {
    Group save(Group group);
    Group get(String id);
    List<Group> getAll();
    Group edit(Group group);
    Group delete(String id);

    Group getByName(String name);
    List<Group> getAllByName(String name);
}

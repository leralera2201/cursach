package edu.stas.cursach.dao.group.interfaces;

import edu.stas.cursach.model.Group;

import java.util.List;

public interface IGroupDao {
    Group save(Group group);
    Group get(String id);
    List<Group> getAll();
    Group edit(Group group);
    Group delete(String id);
}

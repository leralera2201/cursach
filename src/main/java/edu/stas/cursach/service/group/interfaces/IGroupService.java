package edu.stas.cursach.service.group.interfaces;

import edu.stas.cursach.model.Group;

import java.util.List;

public interface IGroupService {
    Group save(Group group);
    Group get(String id);
    List<Group> getAll();
    Group edit(Group group);
    Group delete(String id);
}

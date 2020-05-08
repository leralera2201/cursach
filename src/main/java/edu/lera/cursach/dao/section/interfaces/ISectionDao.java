package edu.lera.cursach.dao.section.interfaces;

import java.util.List;

public interface ISectionDao {
    edu.lera.cursach.model.Section save(edu.lera.cursach.model.Section section);
    edu.lera.cursach.model.Section get(String id);
    List<edu.lera.cursach.model.Section> getAll();
    edu.lera.cursach.model.Section edit(edu.lera.cursach.model.Section section);
    edu.lera.cursach.model.Section delete(String id);
}

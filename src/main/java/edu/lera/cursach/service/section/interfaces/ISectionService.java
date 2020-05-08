package edu.lera.cursach.service.section.interfaces;


import edu.lera.cursach.model.Section;

import java.util.List;

public interface ISectionService {
    Section save(Section section);
    Section get(String id);
    List<Section> getAll();
    Section edit(Section section);
    Section delete(String id);

    Section getByName(String name);
    List<Section> getAllByName(String name);
}

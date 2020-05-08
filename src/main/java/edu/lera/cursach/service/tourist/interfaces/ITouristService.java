package edu.lera.cursach.service.tourist.interfaces;


import edu.lera.cursach.model.Tourist;

import java.util.List;

public interface ITouristService {
    edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist);
    edu.lera.cursach.model.Tourist get(String id);
    List<edu.lera.cursach.model.Tourist> getAll();
    edu.lera.cursach.model.Tourist edit(edu.lera.cursach.model.Tourist tourist);
    edu.lera.cursach.model.Tourist delete(String id);

    Tourist getByName(String name);
    List<Tourist> getAllByName(String name);

}

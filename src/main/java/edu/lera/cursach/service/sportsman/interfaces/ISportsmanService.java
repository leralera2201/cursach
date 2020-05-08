package edu.lera.cursach.service.sportsman.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Sportsman;

import java.util.List;

public interface ISportsmanService {
    Sportsman save(Sportsman sportsman);
    Sportsman get(String id);
    List<Sportsman> getAll();
    Sportsman edit(Sportsman sportsman);
    Sportsman delete(String id);

    Sportsman getByName(String name);
    List<Sportsman> getAllByName(String name);
}

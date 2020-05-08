package edu.lera.cursach.dao.sportsman.interfaces;

import java.util.List;

public interface ISportsmanDao {
    edu.lera.cursach.model.Sportsman save(edu.lera.cursach.model.Sportsman sportsman);
    edu.lera.cursach.model.Sportsman get(String id);
    List<edu.lera.cursach.model.Sportsman> getAll();
    edu.lera.cursach.model.Sportsman edit(edu.lera.cursach.model.Sportsman sportsman);
    edu.lera.cursach.model.Sportsman delete(String id);
}

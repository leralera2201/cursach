package edu.lera.cursach.service.amator.interfaces;

import edu.lera.cursach.model.Amator;

import java.util.List;

public interface IAmatorService {
    Amator save(Amator amator);
    Amator get(String id);
    List<Amator> getAll();
    Amator edit(Amator amator);
    Amator delete(String id);
    Amator getByName(String name);
    List<Amator> getAllByName(String name);
}

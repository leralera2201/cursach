package edu.lera.cursach.service.captain.interfaces;

import edu.lera.cursach.model.Captain;

import java.util.List;

public interface ICaptainService {
    Captain save(Captain captain);
    Captain get(String id);
    List<Captain> getAll();
    Captain edit(Captain captain);
    Captain delete(String id);

    Captain getByName(String name);
    List<Captain> getAllByName(String name);
}

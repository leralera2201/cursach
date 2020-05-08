package edu.lera.cursach.dao.captain.interfaces;

import java.util.List;

public interface ICaptainDao {
    edu.lera.cursach.model.Captain save(edu.lera.cursach.model.Captain captain);
    edu.lera.cursach.model.Captain get(String id);
    List<edu.lera.cursach.model.Captain> getAll();
    edu.lera.cursach.model.Captain edit(edu.lera.cursach.model.Captain captain);
    edu.lera.cursach.model.Captain delete(String id);
}

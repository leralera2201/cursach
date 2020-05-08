package edu.lera.cursach.dao.group.impls;

import edu.lera.cursach.dao.group.interfaces.IGroupDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupDaoImplFake implements IGroupDao {
    @Autowired
    DataSet dataSet;

    @Override
    public edu.lera.cursach.model.Group save(edu.lera.cursach.model.Group group) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Group get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Group> getAll() {
        return dataSet.getGroups();
    }

    @Override
    public edu.lera.cursach.model.Group edit(edu.lera.cursach.model.Group group) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Group delete(String id) {
        return null;
    }
}

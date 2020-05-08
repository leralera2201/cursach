package edu.lera.cursach.dao.competition.impls;

import edu.lera.cursach.dao.competition.interfaces.ICompetitionDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompetitionDaoImplFake implements ICompetitionDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.Competition save(edu.lera.cursach.model.Competition competition) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Competition get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.Competition> getAll() {
        return dataSet.getCompetitions();
    }

    @Override
    public edu.lera.cursach.model.Competition edit(edu.lera.cursach.model.Competition competition) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.Competition delete(String id) {
        return null;
    }
}

package edu.lera.cursach.dao.participationInCompetition.impls;

import edu.lera.cursach.dao.participationInCompetition.interfaces.IParticipationInCompetitionDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParticipationInCompetitionDaoImplFake implements IParticipationInCompetitionDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.ParticipationInCompetition save(edu.lera.cursach.model.ParticipationInCompetition participationInCompetition) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.ParticipationInCompetition get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.ParticipationInCompetition> getAll() {
        return dataSet.getParticipationInCompetitions();
    }

    @Override
    public edu.lera.cursach.model.ParticipationInCompetition edit(edu.lera.cursach.model.ParticipationInCompetition participationInCompetition) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.ParticipationInCompetition delete(String id) {
        return null;
    }
}

package edu.lera.cursach.dao.participationInTour.impls;

import edu.lera.cursach.dao.participationInTour.interfaces.IParticipationInTourDao;
import edu.lera.cursach.dataSet.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParticipationInTourDaoImplFake implements IParticipationInTourDao {
    @Autowired
    DataSet dataSet;

//    @Override
//    public edu.lera.cursach.model.Tourist save(edu.lera.cursach.model.Tourist tourist) {
//        dataSet.getTourists().add(tourist);
//        return tourist;
//    }
    @Override
    public edu.lera.cursach.model.ParticipationInTour save(edu.lera.cursach.model.ParticipationInTour participationInTour) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.ParticipationInTour get(String id) {
        return null;
    }

    @Override
    public List<edu.lera.cursach.model.ParticipationInTour> getAll() {
        return dataSet.getParticipationInTours();
    }

    @Override
    public edu.lera.cursach.model.ParticipationInTour edit(edu.lera.cursach.model.ParticipationInTour participationInTour) {
        return null;
    }

    @Override
    public edu.lera.cursach.model.ParticipationInTour delete(String id) {
        return null;
    }
}

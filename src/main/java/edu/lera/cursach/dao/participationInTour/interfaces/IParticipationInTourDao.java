package edu.lera.cursach.dao.participationInTour.interfaces;

import java.util.List;

public interface IParticipationInTourDao {
    edu.lera.cursach.model.ParticipationInTour save(edu.lera.cursach.model.ParticipationInTour participationInTour);
    edu.lera.cursach.model.ParticipationInTour get(String id);
    List<edu.lera.cursach.model.ParticipationInTour> getAll();
    edu.lera.cursach.model.ParticipationInTour edit(edu.lera.cursach.model.ParticipationInTour participationInTour);
    edu.lera.cursach.model.ParticipationInTour delete(String id);
}

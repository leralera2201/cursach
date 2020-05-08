package edu.lera.cursach.service.participationInTour.interfaces;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.ParticipationInTour;

import java.util.List;

public interface IParticipationInTourService {
    ParticipationInTour save(ParticipationInTour participationInTour);
    ParticipationInTour get(String id);
    List<ParticipationInTour> getAll();
    ParticipationInTour edit(ParticipationInTour participationInTour);
    ParticipationInTour delete(String id);

    ParticipationInTour getByTouristName(String name);
    List<ParticipationInTour> getAllByTouristName(String name);
    ParticipationInTour getByTourName(String name);
    List<ParticipationInTour> getAllByTourName(String name);
}

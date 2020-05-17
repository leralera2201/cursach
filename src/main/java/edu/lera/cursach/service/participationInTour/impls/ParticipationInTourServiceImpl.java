package edu.lera.cursach.service.participationInTour.impls;

import edu.lera.cursach.dao.participationInTour.impls.ParticipationInTourDaoImplFake;
import edu.lera.cursach.model.ParticipationInCompetition;
import edu.lera.cursach.model.ParticipationInTour;
import edu.lera.cursach.repository.ParticipationInTourRepository;
import edu.lera.cursach.service.participationInTour.interfaces.IParticipationInTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipationInTourServiceImpl implements IParticipationInTourService {
    @Autowired
    ParticipationInTourDaoImplFake dao;
    @Autowired
    ParticipationInTourRepository repository;

    @PostConstruct
    void init(){
//        List<ParticipationInTour> list = dao.getAll();
        List<ParticipationInTour> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<ParticipationInTour> getAll() {
        return repository.findAll();
    }

    @Override
    public ParticipationInTour edit(ParticipationInTour participationInTour) {
        participationInTour.setModified_date(LocalDateTime.now());
        return repository.save(participationInTour);
    }


    @Override
    public ParticipationInTour delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public ParticipationInTour getByTouristName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTourist().getName().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<ParticipationInTour> getAllByTouristName(String name) {
        return repository.findByTourist_Name(name);
    }

    @Override
    public ParticipationInTour getByTourName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTour().getTour_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<ParticipationInTour> getAllByTourName(String name) {
        return repository.findByTour_TourName(name);
    }


    @Override
    public ParticipationInTour save(ParticipationInTour participationInTour) {
        participationInTour.setCreated_date(LocalDateTime.now());
        participationInTour.setModified_date(LocalDateTime.now());
        return repository.save(participationInTour);
    }

    @Override
    public ParticipationInTour get(String id) {
        return repository.findById(id).orElse(null);
    }

//    @Override
//    public Tourist get(String id) {
//        return dao.getAll().stream().filter(item -> item.getId().equals(id))
//            .findFirst().orElse(null);
//    }
//
//    @Override
//    public List<Tourist> getAll() {
//        return dao.getAll();
//    }


//
//    @Override
//    public Tourist delete(String id) {
//        Tourist tourist = this.get(id);
//        dao.getAll().remove(tourist);
//        return tourist;
//    }

    public List<ParticipationInTour> search(String word) {

        List<ParticipationInTour> found = new ArrayList<>();

        List<ParticipationInTour> participationInTours = this.getAll();

        for (int i = 0; i < participationInTours.size(); i++) {

            if (participationInTours.get(i).getTourist().getName()
                    .toLowerCase().contains(word.toLowerCase()) ||
                    participationInTours.get(i).getTour().getTour_name()
                    .toLowerCase().contains(word.toLowerCase())
            ) {

                found.add(participationInTours.get(i));
            }

        }
        return found;
    }
    public List<ParticipationInTour> sortByTouristName() {

        return this.getAll().stream().sorted(Comparator.comparing(ParticipationInTour::getTouristName))
                .collect(Collectors.toList());
    }
    public List<ParticipationInTour> sortByTourName() {

        return this.getAll().stream().sorted(Comparator.comparing(ParticipationInTour::getTourName))
                .collect(Collectors.toList());
    }
}

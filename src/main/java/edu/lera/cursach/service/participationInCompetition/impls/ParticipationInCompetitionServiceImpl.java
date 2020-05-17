package edu.lera.cursach.service.participationInCompetition.impls;

import edu.lera.cursach.dao.participationInCompetition.impls.ParticipationInCompetitionDaoImplFake;
import edu.lera.cursach.model.PlannedTour;
import edu.lera.cursach.repository.ParticipationInCompetitionRepository;
import edu.lera.cursach.model.ParticipationInCompetition;
import edu.lera.cursach.model.ParticipationInCompetition;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.participationInCompetition.interfaces.IParticipationInCompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipationInCompetitionServiceImpl implements IParticipationInCompetitionService {
    @Autowired
    ParticipationInCompetitionDaoImplFake dao;
    @Autowired
    ParticipationInCompetitionRepository repository;

    @PostConstruct
    void init(){
//        List<ParticipationInCompetition> list = dao.getAll();
        List<ParticipationInCompetition> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<ParticipationInCompetition> getAll() {
        return repository.findAll();
    }

    @Override
    public ParticipationInCompetition edit(ParticipationInCompetition participationInCompetition) {
        participationInCompetition.setModified_date(LocalDateTime.now());
        return repository.save(participationInCompetition);
    }


    @Override
    public ParticipationInCompetition delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public ParticipationInCompetition getByTouristName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTourist().getName().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<ParticipationInCompetition> getAllByTouristName(String name) {
        return repository.findByTourist_Name(name);
    }

    @Override
    public ParticipationInCompetition getByCompetitionName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getCompetition().getCompetition_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<ParticipationInCompetition> getAllByCompetitionName(String name) {
        return repository.findByCompetition_CompetitionName(name);
    }


    @Override
    public ParticipationInCompetition save(ParticipationInCompetition participationInCompetition) {
        participationInCompetition.setCreated_date(LocalDateTime.now());
        participationInCompetition.setModified_date(LocalDateTime.now());
        return repository.save(participationInCompetition);
    }

    @Override
    public ParticipationInCompetition get(String id) {
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

    public List<ParticipationInCompetition> search(String word) {

        List<ParticipationInCompetition> found = new ArrayList<>();

        List<ParticipationInCompetition> participationInCompetitions = this.getAll();

        for (int i = 0; i < participationInCompetitions.size(); i++) {

            if (participationInCompetitions.get(i).getTourist().getName()
                    .toLowerCase().contains(word.toLowerCase()) ||
                    participationInCompetitions.get(i).getCompetition().getCompetition_name()
                            .toLowerCase().contains(word.toLowerCase())) {

                found.add(participationInCompetitions.get(i));
            }

        }
        return found;
    }
    public List<ParticipationInCompetition> sortByTouristName() {

        return this.getAll().stream().sorted(Comparator.comparing(ParticipationInCompetition::getTouristName))
                .collect(Collectors.toList());
    }
    public List<ParticipationInCompetition> sortByCompetitionName() {

        return this.getAll().stream().sorted(Comparator.comparing(ParticipationInCompetition::getCompetitionName))
                .collect(Collectors.toList());
    }
}

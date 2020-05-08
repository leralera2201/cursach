package edu.lera.cursach.service.plannedTour.impls;

import edu.lera.cursach.dao.plannedTour.impls.PlannedTourDaoImplFake;
import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.PlannedTourRepository;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.ParticipationInCompetition;
import edu.lera.cursach.model.PlannedTour;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.plannedTour.interfaces.IPlannedTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlannedTourServiceImpl implements IPlannedTourService {
    @Autowired
    PlannedTourDaoImplFake dao;
    @Autowired
    PlannedTourRepository repository;

    @PostConstruct
    void init(){
        List<PlannedTour> list = dao.getAll();
//        List<Tourist> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<PlannedTour> getAll() {
        return repository.findAll();
    }

    @Override
    public PlannedTour edit(PlannedTour plannedTour) {
        plannedTour.setModified_date(LocalDateTime.now());
        return repository.save(plannedTour);
    }


    @Override
    public PlannedTour delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public PlannedTour getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTour().getTour_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<PlannedTour> getAllByName(String name) {
        return repository.findByTour_TourName(name);
    }


    @Override
    public PlannedTour save(PlannedTour plannedTour) {
        plannedTour.setCreated_date(LocalDateTime.now());
        plannedTour.setModified_date(LocalDateTime.now());
        return repository.save(plannedTour);
    }

    @Override
    public PlannedTour get(String id) {
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
    public List<PlannedTour> search(String word) {

        List<PlannedTour> found = new ArrayList<>();

        List<PlannedTour> plannedTours = this.getAll();

        for (int i = 0; i < plannedTours.size(); i++) {

            if (plannedTours.get(i).getTour().getTour_name()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(plannedTours.get(i));
            }

        }
        return found;
    }

    public List<PlannedTour> sortByDate() {

        return this.getAll().stream().sorted(Comparator.comparing(PlannedTour::getDate))
                .collect(Collectors.toList());
    }

}

package edu.lera.cursach.service.unplannedTour.impls;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.repository.UnplannedTourRepository;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.dao.unplannedTour.impls.UnplannedTourDaoImplFake;
import edu.lera.cursach.model.TourType;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.model.UnplannedTour;
import edu.lera.cursach.service.unplannedTour.interfaces.IUnplannedTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UnplannedTourServiceImpl implements IUnplannedTourService {
    @Autowired
    UnplannedTourDaoImplFake dao;
    @Autowired
    UnplannedTourRepository repository;

    @PostConstruct
    void init(){
//        List<UnplannedTour> list = dao.getAll();
        List<UnplannedTour> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<UnplannedTour> getAll() {
        return repository.findAll();
    }

    @Override
    public UnplannedTour edit(UnplannedTour unplannedTour) {
        unplannedTour.setModified_date(LocalDateTime.now());
        return repository.save(unplannedTour);
    }


    @Override
    public UnplannedTour delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public UnplannedTour getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTour().getTour_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<UnplannedTour> getAllByName(String name) {
        return repository.findByTour_TourName(name);
    }


    @Override
    public UnplannedTour save(UnplannedTour unplannedTour) {
        unplannedTour.setCreated_date(LocalDateTime.now());
        unplannedTour.setModified_date(LocalDateTime.now());
        return repository.save(unplannedTour);
    }

    @Override
    public UnplannedTour get(String id) {
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
    public List<UnplannedTour> search(String word) {

        List<UnplannedTour> found = new ArrayList<>();

        List<UnplannedTour> unplannedTours = this.getAll();

        for (int i = 0; i < unplannedTours.size(); i++) {

            if (unplannedTours.get(i).getTour().getTour_name()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(unplannedTours.get(i));
            }

        }
        return found;
    }
    public List<UnplannedTour> sortByDate() {

        return this.getAll().stream().sorted(Comparator.comparing(UnplannedTour::getDate))
                .collect(Collectors.toList());
    }

}

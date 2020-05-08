package edu.lera.cursach.service.tour.impls;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.TourRepository;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.dao.tour.impls.TourDaoImplFake;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.Sportsman;
import edu.lera.cursach.model.Tour;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.tour.interfaces.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourServiceImpl implements ITourService {
    @Autowired
    TourDaoImplFake dao;
    @Autowired
    TourRepository repository;

    @PostConstruct
    void init(){
        List<Tour> list = dao.getAll();
//        List<Tourist> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<Tour> getAll() {
        return repository.findAll();
    }

    @Override
    public Tour edit(Tour tour) {
        tour.setModified_date(LocalDateTime.now());
        return repository.save(tour);
    }


    @Override
    public Tour delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Tour getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTour_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Tour> getAllByName(String name) {
        return repository.findByTourName(name);
    }


    @Override
    public Tour save(Tour tour) {
        tour.setCreated_date(LocalDateTime.now());
        tour.setModified_date(LocalDateTime.now());
        return repository.save(tour);
    }

    @Override
    public Tour get(String id) {
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

    public List<Tour> search(String word) {

        List<Tour> found = new ArrayList<>();

        List<Tour> tours = this.getAll();

        for (int i = 0; i < tours.size(); i++) {

            if (tours.get(i).getTour_name()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(tours.get(i));
            }

        }
        return found;
    }
    public List<Tour> sortByName() {

        return this.getAll().stream().sorted(Comparator.comparing(Tour::getTour_name))
                .collect(Collectors.toList());
    }
    public List<Tour> sortByDate() {

        return this.getAll().stream().sorted(Comparator.comparing(Tour::getTour_date))
                .collect(Collectors.toList());
    }
}

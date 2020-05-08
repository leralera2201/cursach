package edu.lera.cursach.service.sportsman.impls;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.SportsmanRepository;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.dao.sportsman.impls.SportsmanDaoImplFake;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.Section;
import edu.lera.cursach.model.Sportsman;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.sportsman.interfaces.ISportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportsmanServiceImpl implements ISportsmanService {
    @Autowired
    SportsmanDaoImplFake dao;
    @Autowired
    SportsmanRepository repository;

    @PostConstruct
    void init(){
        List<Sportsman> list = dao.getAll();
//        List<Tourist> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<Sportsman> getAll() {
        return repository.findAll();
    }

    @Override
    public Sportsman edit(Sportsman sportsman) {
        sportsman.setModified_date(LocalDateTime.now());
        return repository.save(sportsman);
    }


    @Override
    public Sportsman delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Sportsman getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTourist().getName().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Sportsman> getAllByName(String name) {
        return repository.findByTourist_Name(name);
    }


    @Override
    public Sportsman save(Sportsman sportsman) {
        sportsman.setCreated_date(LocalDateTime.now());
        sportsman.setModified_date(LocalDateTime.now());
        return repository.save(sportsman);
    }

    @Override
    public Sportsman get(String id) {
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

    public List<Sportsman> search(String word) {

        List<Sportsman> found = new ArrayList<>();

        List<Sportsman> sportsmen = this.getAll();

        for (int i = 0; i < sportsmen.size(); i++) {

            if (sportsmen.get(i).getTourist().getName()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(sportsmen.get(i));
            }

        }
        return found;
    }
    public List<Sportsman> sortByName() {

        return this.getAll().stream().sorted(Comparator.comparing(Sportsman::getName))
                .collect(Collectors.toList());
    }
}

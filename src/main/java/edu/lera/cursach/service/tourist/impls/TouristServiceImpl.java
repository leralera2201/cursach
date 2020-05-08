package edu.lera.cursach.service.tourist.impls;

import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.service.tourist.interfaces.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TouristServiceImpl implements ITouristService {
    @Autowired
    TouristDaoImplFake dao;
    @Autowired
    TouristRepository repository;

    @PostConstruct
    void init(){
//        List<Tourist> list = dao.getAll();
        List<Tourist> list = repository.findAll();
        repository.saveAll(list);
    }
    @Override
    public Tourist getByName(String name) {

        return repository.findAll().stream()
                .filter(item-> item.getName().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Tourist> getAllByName(String name) {
        return repository.findByName(name);
    }
    @Override
    public List<Tourist> getAll() {
        return repository.findAll();
    }

    @Override
    public Tourist edit(Tourist tourist) {
        tourist.setModified_date(LocalDateTime.now());
        return repository.save(tourist);
    }


    @Override
    public Tourist delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }


    @Override
    public Tourist save(Tourist tourist) {
        tourist.setCreated_date(LocalDateTime.now());
        tourist.setModified_date(LocalDateTime.now());
        return repository.save(tourist);
    }

    @Override
    public Tourist get(String id) {
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
    public List<Tourist> search(String word) {
        return this.getAll().stream()
                .filter(tourist -> tourist.getName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Tourist> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Tourist::getName))
                .collect(Collectors.toList());
    }


}

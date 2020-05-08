package edu.lera.cursach.service.amator.impls;

import edu.lera.cursach.dao.amator.impls.AmatorDaoImplFake;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.repository.AmatorRepository;
import edu.lera.cursach.service.amator.interfaces.IAmatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AmatorServiceImpl implements IAmatorService {
    @Autowired
    AmatorDaoImplFake dao;
    @Autowired
    AmatorRepository repository;

    @PostConstruct
    void init(){
        List<Amator> list = dao.getAll();
//        List<Tourist> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<Amator> getAll() {
        return repository.findAll();
    }

    @Override
    public Amator edit(Amator amator) {
        amator.setModified_date(LocalDateTime.now());
        return repository.save(amator);
    }


    @Override
    public Amator delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Amator getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTourist().getName().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Amator> getAllByName(String name) {
        return repository.findByTourist_Name(name);
    }


    @Override
    public Amator save(Amator amator) {
        amator.setCreated_date(LocalDateTime.now());
        amator.setModified_date(LocalDateTime.now());
        return repository.save(amator);
    }

    @Override
    public Amator get(String id) {
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

    public List<Amator> search(String word) {

        List<Amator> found = new ArrayList<>();

        List<Amator> amators = this.getAll();

        for (int i = 0; i < amators.size(); i++) {

            if (amators.get(i).getTourist().getName()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(amators.get(i));
            }

        }
        return found;
    }
    public List<Amator> sortByName() {

        return this.getAll().stream().sorted(Comparator.comparing(Amator::getName))
                .collect(Collectors.toList());
    }

}

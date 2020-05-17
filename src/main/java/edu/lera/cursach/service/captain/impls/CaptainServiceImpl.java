package edu.lera.cursach.service.captain.impls;

import edu.lera.cursach.dao.captain.impls.CaptainDaoImplFake;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Captain;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.repository.CaptainRepository;
import edu.lera.cursach.service.captain.interfaces.ICaptainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaptainServiceImpl implements ICaptainService {
    @Autowired
    CaptainDaoImplFake dao;
    @Autowired
    CaptainRepository repository;

    @PostConstruct
    void init(){
//        List<Captain> list = dao.getAll();
        List<Captain> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<Captain> getAll() {
        return repository.findAll();
    }

    @Override
    public Captain edit(Captain captain) {
        captain.setModified_date(LocalDateTime.now());
        return repository.save(captain);
    }


    @Override
    public Captain delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Captain getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getName().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Captain> getAllByName(String name) {
        return repository.findByName(name);
    }


    @Override
    public Captain save(Captain captain) {
        captain.setCreated_date(LocalDateTime.now());
        captain.setModified_date(LocalDateTime.now());
        return repository.save(captain);
    }

    @Override
    public Captain get(String id) {
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

    public List<Captain> search(String word) {

        List<Captain> found = new ArrayList<>();

        List<Captain> captains = this.getAll();

        for (int i = 0; i < captains.size(); i++) {

            if (captains.get(i).getName()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(captains.get(i));
            }

        }
        return found;
    }public List<Captain> sortByName() {

        return this.getAll().stream().sorted(Comparator.comparing(Captain::getName))
                .collect(Collectors.toList());
    }

}

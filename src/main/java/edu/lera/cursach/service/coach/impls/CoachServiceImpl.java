package edu.lera.cursach.service.coach.impls;

import edu.lera.cursach.dao.coach.impls.CoachDaoImplFake;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Coach;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.repository.CoachRepository;
import edu.lera.cursach.service.coach.interfaces.ICoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachServiceImpl implements ICoachService {
    @Autowired
    CoachDaoImplFake dao;
    @Autowired
    CoachRepository repository;

    @PostConstruct
    void init(){
//        List<Coach> list = dao.getAll();
        List<Coach> list = repository.findAll();
        repository.saveAll(list);
    }


//    public List<Coach>  getCoachWhenSalaryGreaterThan(){
//
//        return  repository.findBySalaryGreaterThanEqual(1200);
//    }
//    public List<Coach>  getCoachWhenSalaryLessThan(){
//
//        return  repository.findBySalaryLessThanEqual(1200);
//    }
//    public List<Coach> getCoachBySpecialityContains() {
//        return repository.findBySpecialityContains("something");
//    }
//    public List<Coach> getCoachByBirthdayEqual() {
//        return repository.findByTourist_Birthday(LocalDate.of(2000,02,02));
//    }
//    public List<Coach> getCoachBySex() {
//        return repository.findByTourist_Sex(true);
//    }

    @Override
    public List<Coach> getAll() {
        return repository.findAll();
    }

    @Override
    public Coach edit(Coach coach) {
        coach.setModified_date(LocalDateTime.now());
        return repository.save(coach);
    }


    @Override
    public Coach delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Coach getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTourist().getName().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Coach> getAllByName(String name) {
        return repository.findByTourist_Name(name);
    }


    @Override
    public Coach save(Coach coach) {
        coach.setCreated_date(LocalDateTime.now());
        coach.setModified_date(LocalDateTime.now());
        return repository.save(coach);
    }

    @Override
    public Coach get(String id) {
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
    public List<Coach> search(String word) {

        List<Coach> found = new ArrayList<>();

        List<Coach> coaches = this.getAll();

        for (int i = 0; i < coaches.size(); i++) {

            if (coaches.get(i).getTourist().getName()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(coaches.get(i));
            }

        }
        return found;
    }
    public List<Coach> sortByName() {

        return this.getAll().stream().sorted(Comparator.comparing(Coach::getName))
                .collect(Collectors.toList());
    }

}

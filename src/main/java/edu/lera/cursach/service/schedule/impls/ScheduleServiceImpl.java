package edu.lera.cursach.service.schedule.impls;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.ScheduleRepository;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.dao.schedule.impls.ScheduleDaoImplFake;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.PlannedTour;
import edu.lera.cursach.model.Schedule;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.schedule.interfaces.IScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements IScheduleService {
    @Autowired
    ScheduleDaoImplFake dao;
    @Autowired
    ScheduleRepository repository;

    @PostConstruct
    void init(){
        List<Schedule> list = dao.getAll();
//        List<Tourist> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<Schedule> getAll() {
        return repository.findAll();
    }

    @Override
    public Schedule edit(Schedule schedule) {
        schedule.setModified_date(LocalDateTime.now());
        return repository.save(schedule);
    }


    @Override
    public Schedule delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Schedule getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTrain_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Schedule> getAllByName(String name) {
        return repository.findByTrainName(name);
    }


    @Override
    public Schedule save(Schedule schedule) {
        schedule.setCreated_date(LocalDateTime.now());
        schedule.setModified_date(LocalDateTime.now());
        return repository.save(schedule);
    }

    @Override
    public Schedule get(String id) {
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

    public List<Schedule> search(String word) {

        List<Schedule> found = new ArrayList<>();

        List<Schedule> schedules = this.getAll();

        for (int i = 0; i < schedules.size(); i++) {

            if (schedules.get(i).getTrain_name()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(schedules.get(i));
            }

        }
        return found;
    }

    public List<Schedule> sortByDate() {

        return this.getAll().stream().sorted(Comparator.comparing(Schedule::getStarted_datetime))
                .collect(Collectors.toList());
    }
}

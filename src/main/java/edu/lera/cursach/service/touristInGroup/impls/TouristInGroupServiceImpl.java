package edu.lera.cursach.service.touristInGroup.impls;

import edu.lera.cursach.model.ParticipationInCompetition;
import edu.lera.cursach.repository.TouristInGroupRepository;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.dao.touristInGroup.impls.TouristInGroupDaoImplFake;
import edu.lera.cursach.model.Tour;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.model.TouristInGroup;
import edu.lera.cursach.service.touristInGroup.interfaces.ITouristInGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TouristInGroupServiceImpl implements ITouristInGroupService {
    @Autowired
    TouristInGroupDaoImplFake dao;
    @Autowired
    TouristInGroupRepository repository;

    @PostConstruct
    void init(){
//        List<TouristInGroup> list = dao.getAll();
        List<TouristInGroup> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<TouristInGroup> getAll() {
        return repository.findAll();
    }

    @Override
    public TouristInGroup edit(TouristInGroup touristInGroup) {
        touristInGroup.setModified_date(LocalDateTime.now());
        return repository.save(touristInGroup);
    }


    @Override
    public TouristInGroup delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public TouristInGroup getByGroupName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getGroup().getGroup_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<TouristInGroup> getAllByGroupName(String name) {
        return repository.findByGroup_GroupName(name);
    }

    @Override
    public TouristInGroup getByTouristName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getTourist().getName().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<TouristInGroup> getAllByTouristName(String name) {
        return repository.findByTourist_Name(name);
    }


    @Override
    public TouristInGroup save(TouristInGroup touristInGroup) {
        touristInGroup.setCreated_date(LocalDateTime.now());
        touristInGroup.setModified_date(LocalDateTime.now());
        return repository.save(touristInGroup);
    }

    @Override
    public TouristInGroup get(String id) {
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
    public List<TouristInGroup> search(String word) {

        List<TouristInGroup> found = new ArrayList<>();

        List<TouristInGroup> touristInGroups = this.getAll();

        for (int i = 0; i < touristInGroups.size(); i++) {

            if (touristInGroups.get(i).getTourist().getName()
                    .toLowerCase().contains(word.toLowerCase()) ||
                    touristInGroups.get(i).getGroup().getGroup_name()
                    .toLowerCase().contains(word.toLowerCase())
            ) {

                found.add(touristInGroups.get(i));
            }

        }
        return found;
    }

    public List<TouristInGroup> sortByTouristName() {

        return this.getAll().stream().sorted(Comparator.comparing(TouristInGroup::getTouristName))
                .collect(Collectors.toList());
    }
    public List<TouristInGroup> sortByGroupName() {

        return this.getAll().stream().sorted(Comparator.comparing(TouristInGroup::getGroupName))
                .collect(Collectors.toList());
    }

}

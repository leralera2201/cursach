package edu.lera.cursach.service.tourType.impls;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.TourTypeRepository;
import edu.lera.cursach.dao.tourType.impls.TourTypeDaoImplFake;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.TourType;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.model.TouristInGroup;
import edu.lera.cursach.service.tourType.interfaces.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourTypeServiceImpl implements ITouristService {
    @Autowired
    TourTypeDaoImplFake dao;
    @Autowired
    TourTypeRepository repository;

    @PostConstruct
    void init(){
        List<TourType> list = dao.getAll();
//        List<Tourist> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<TourType> getAll() {
        return repository.findAll();
    }

    @Override
    public TourType edit(TourType tourType) {
        tourType.setModified_date(LocalDateTime.now());
        return repository.save(tourType);
    }


    @Override
    public TourType delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public TourType getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getType_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<TourType> getAllByName(String name) {
        return repository.findByTypeName(name);
    }


    @Override
    public TourType save(TourType tourType) {
        tourType.setCreated_date(LocalDateTime.now());
        tourType.setModified_date(LocalDateTime.now());
        return repository.save(tourType);
    }

    @Override
    public TourType get(String id) {
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

    public List<TourType> search(String word) {

        List<TourType> found = new ArrayList<>();

        List<TourType> tourTypes = this.getAll();

        for (int i = 0; i < tourTypes.size(); i++) {

            if (tourTypes.get(i).getType_name()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(tourTypes.get(i));
            }

        }
        return found;
    }
    public List<TourType> sortByName() {

        return this.getAll().stream().sorted(Comparator.comparing(TourType::getType_name))
                .collect(Collectors.toList());
    }
}

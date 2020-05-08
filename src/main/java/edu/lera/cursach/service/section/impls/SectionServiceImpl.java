package edu.lera.cursach.service.section.impls;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.SectionRepository;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.dao.section.impls.SectionDaoImplFake;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.Schedule;
import edu.lera.cursach.model.Section;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.section.interfaces.ISectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements ISectionService {
    @Autowired
    SectionDaoImplFake dao;
    @Autowired
    SectionRepository repository;

    @PostConstruct
    void init(){
        List<Section> list = dao.getAll();
//        List<Tourist> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<Section> getAll() {
        return repository.findAll();
    }

    @Override
    public Section edit(Section section) {
        section.setModified_date(LocalDateTime.now());
        return repository.save(section);
    }


    @Override
    public Section delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Section getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getSection_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Section> getAllByName(String name) {
        return repository.findBySectionName(name);
    }


    @Override
    public Section save(Section section) {
        section.setCreated_date(LocalDateTime.now());
        section.setModified_date(LocalDateTime.now());
        return repository.save(section);
    }

    @Override
    public Section get(String id) {
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

    public List<Section> search(String word) {

        List<Section> found = new ArrayList<>();

        List<Section> sections = this.getAll();

        for (int i = 0; i < sections.size(); i++) {

            if (sections.get(i).getSection_name()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(sections.get(i));
            }

        }
        return found;
    }
    public List<Section> sortByName() {

        return this.getAll().stream().sorted(Comparator.comparing(Section::getSection_name))
                .collect(Collectors.toList());
    }
}

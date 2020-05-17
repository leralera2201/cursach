package edu.lera.cursach.service.competition.impls;

import edu.lera.cursach.dao.competition.impls.CompetitionDaoImplFake;
import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.CompetitionRepository;
import edu.lera.cursach.repository.TouristRepository;
import edu.lera.cursach.dao.tourist.impls.TouristDaoImplFake;
import edu.lera.cursach.model.Coach;
import edu.lera.cursach.model.Competition;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.competition.interfaces.ICompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetitionServiceImpl implements ICompetitionService {
    @Autowired
    CompetitionDaoImplFake dao;
    @Autowired
    CompetitionRepository repository;

    @PostConstruct
    void init(){
//        List<Competition> list = dao.getAll();
        List<Competition> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<Competition> getAll() {
        return repository.findAll();
    }

    @Override
    public Competition edit(Competition competition) {
        competition.setModified_date(LocalDateTime.now());
        return repository.save(competition);
    }


    @Override
    public Competition delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Competition getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getCompetition_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Competition> getAllByName(String name) {
        return repository.findByCompetitionName(name);

    }


    @Override
    public Competition save(Competition competition) {
        competition.setCreated_date(LocalDateTime.now());
        competition.setModified_date(LocalDateTime.now());
        return repository.save(competition);
    }

    @Override
    public Competition get(String id) {
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

    public List<Competition> search(String word) {

        List<Competition> found = new ArrayList<>();

        List<Competition> competitions = this.getAll();

        for (int i = 0; i < competitions.size(); i++) {

            if (competitions.get(i).getCompetition_name()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(competitions.get(i));
            }

        }
        return found;
    }

    public List<Competition> sortByDate() {

        return this.getAll().stream().sorted(Comparator.comparing(Competition::getCompetition_date))
                .collect(Collectors.toList());
    }
}

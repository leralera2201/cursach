package edu.lera.cursach.service.group.impls;

import edu.lera.cursach.dao.group.impls.GroupDaoImplFake;
import edu.lera.cursach.model.Amator;
import edu.lera.cursach.repository.GroupRepository;
import edu.lera.cursach.model.Group;
import edu.lera.cursach.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupDaoImplFake dao;
    @Autowired
    GroupRepository repository;

    @PostConstruct
    void init(){
//        List<Group> list = dao.getAll();
        List<Group> list = repository.findAll();
        repository.saveAll(list);
    }


    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public Group edit(Group group) {
        group.setModified_date(LocalDateTime.now());
        return repository.save(group);
    }


    @Override
    public Group delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Group getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getGroup_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Group> getAllByName(String groupName) {
        return repository.findByGroupName(groupName);
    }


    @Override
    public Group save(Group group) {
        group.setCreated_date(LocalDateTime.now());
        group.setModified_date(LocalDateTime.now());
        return repository.save(group);
    }

    @Override
    public Group get(String id) {
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

    public List<Group> search(String word) {

        List<Group> found = new ArrayList<>();

        List<Group> groups = this.getAll();

        for (int i = 0; i < groups.size(); i++) {

            if (groups.get(i).getGroup_name()
                    .toLowerCase().contains(word.toLowerCase())) {

                found.add(groups.get(i));
            }

        }
        return found;
    }

    public List<Group> sortByName() {

        return this.getAll().stream().sorted(Comparator.comparing(Group::getGroup_name))
                .collect(Collectors.toList());
    }
}

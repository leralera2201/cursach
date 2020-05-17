package edu.lera.cursach.service.category.impls;

import edu.lera.cursach.dao.category.impls.CategoryDaoImplFake;
import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Captain;
import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.repository.CategoryRepository;
import edu.lera.cursach.service.category.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryDaoImplFake dao;

    @Autowired
    CategoryRepository repository;

    @PostConstruct
    void init(){
//        List<Category> list = dao.getAll();
        List<Category> list = repository.findAll();
        repository.saveAll(list);
    }

//    @Override
//    public Category save(Category category) {
//        return null;
//    }
//
//    @Override
//    public Category get(String id) {
//        return dao.getAll().stream().filter(item -> item.getId().equals(id))
//                .findFirst().orElse(null);
//    }
//
//    @Override
//    public List<Category> getAll() {
//        return dao.getAll();
//    }
//
//    @Override
//    public Category edit(Category category) {
//        return null;
//    }
//
//    @Override
//    public Category delete(String id) {
//        Category category = this.get(id);
//        dao.getAll().remove(category);
//        return category;
//    }




    @Override
    public Category save(Category category) {
        category.setCreated_date(LocalDateTime.now());
        category.setModified_date(LocalDateTime.now());
        return repository.save(category);
    }

    @Override
    public Category get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category edit(Category category) {
        category.setModified_date(LocalDateTime.now());
        return repository.save(category);
    }

    @Override
    public Category delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category getByName(String name) {
        return repository.findAll().stream()
                .filter(item-> item.getCategory_name().equals(name))
                .findFirst().orElse(null)
                ;
    }

    @Override
    public List<Category> getAllByName(String name) {
        return repository.findByCategoryName(name);
    }

    public List<Category> search(String word) {
        return this.getAll().stream()
                .filter(category -> category.getCategory_name()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }


    public List<Category> sortByMark() {

        return this.getAll().stream().sorted(Comparator.comparing(Category::getCategory_mark))
                .collect(Collectors.toList());
    }


}

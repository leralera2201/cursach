package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Category;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryAPIController {
    @Autowired
    CategoryServiceImpl service;

    @RequestMapping("/get/list")
    List<Category> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Category getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Category create(@RequestBody Category category) {
        return service.save(category);
    }

    @RequestMapping("/delete/{id}")
    Category delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping("/get-by-name/{name}")
    Category getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Category> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }
    

    @RequestMapping("/create/{name}")
    Category createCategory(@PathVariable("name") String name){
        return service.save(new Category( Math.random() + name, name,
                0,0, LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    Category updateCategory(@PathVariable("id") String id){
        Category category = service.get(id);
        return service.edit(category);
    }

    @PostMapping("/update")
    Category updateCategoryPost(@RequestBody Category category){
        this.service.save(category);
        return service.edit(category);
    }


}
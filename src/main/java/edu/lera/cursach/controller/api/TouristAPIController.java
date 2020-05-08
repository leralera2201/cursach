package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Tour;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tourist")
public class TouristAPIController {
    @Autowired
    TouristServiceImpl service;
    @Autowired
    CategoryServiceImpl categoryService;

    @RequestMapping("/get/list")
    List<Tourist> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Tourist getById(@PathVariable("id") String id) {
        return service.get(id);
    }


    @RequestMapping("/get-by-name/{name}")
    Tourist getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Tourist> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Tourist create(@RequestBody Tourist tourist) {
        return service.save(tourist);
    }

    @RequestMapping("/create/{name}/{surname}")
    Tourist createTourist(@PathVariable("name") String name,
                      @PathVariable("surname") String surname){
        return service.save(new Tourist( Math.random() + surname, surname, name, "----", "----", "----",
                LocalDate.now(), "----", null, false, LocalDateTime.now(), LocalDateTime.now(), "----"
        ));
    }
    @RequestMapping("/update/{id}")
    Tourist updateTourist(@PathVariable("id") String id){
        Tourist tourist = service.get(id);
        return service.edit(tourist);
    }

    @PostMapping("/update")
    Tourist updateTouristPost(@RequestBody Tourist tourist){
        this.service.save(tourist);
        return service.edit(tourist);
    }

    @RequestMapping("/delete/{id}")
    Tourist delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
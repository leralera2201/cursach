package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.amator.impls.AmatorServiceImpl;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/amator")
public class AmatorAPIController {
    @Autowired
    AmatorServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;

    @RequestMapping("/get/list")
    List<Amator> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Amator getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping("/get-by-name/{name}")
    Amator getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Amator> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Amator create(@RequestBody Amator amator) {
        return service.save(amator);
    }

    @RequestMapping("/create/{id}")
    Amator createAmator(@PathVariable("id") String id){
        return service.save(new Amator( Math.random() + touristService.get(id).getSurname(),
                "----", touristService.get(id),  LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    Amator updateAmator(@PathVariable("id") String id){
        Amator amator = service.get(id);
        return service.edit(amator);
    }
    @PostMapping("/update")
    Amator updateAmatorPost(@RequestBody Amator amator){
        this.service.save(amator);
        return service.edit(amator);
    }

    @RequestMapping("/delete/{id}")
    Amator delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
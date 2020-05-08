package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Sportsman;
import edu.lera.cursach.service.sportsman.impls.SportsmanServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sportsman")
public class SportsmanAPIController {
    @Autowired
    SportsmanServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;

    @RequestMapping("/get/list")
    List<Sportsman> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Sportsman getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Sportsman create(@RequestBody Sportsman sportsman) {
        return service.save(sportsman);
    }


    @RequestMapping("/get-by-name/{name}")
    Sportsman getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Sportsman> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }


    @RequestMapping("/create/{id}")
    Sportsman createSportsman(@PathVariable("id") String id){
        return service.save(new Sportsman( Math.random() + id, "----", touristService.get(id),
                LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    Sportsman updateSportsman(@PathVariable("id") String id){
        Sportsman sportsman = service.get(id);
        return service.edit(sportsman);
    }

    @PostMapping("/update")
    Sportsman updateSportsmanPost(@RequestBody Sportsman sportsman){
        this.service.save(sportsman);
        return service.edit(sportsman);
    }

    @RequestMapping("/delete/{id}")
    Sportsman delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
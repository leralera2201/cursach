package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.TourType;
import edu.lera.cursach.service.tourType.impls.TourTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tour-type")
public class TourTypeAPIController {
    @Autowired
    TourTypeServiceImpl service;

    @RequestMapping("/get/list")
    List<TourType> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    TourType getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    TourType create(@RequestBody TourType tourType) {
        return service.save(tourType);
    }


    @RequestMapping("/get-by-name/{name}")
    TourType getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<TourType> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }

    @RequestMapping("/create/{name}")
    TourType createTourType(@PathVariable("name") String name){
        return service.save(new TourType( Math.random() + name, name, "----",
                LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    TourType updateTourType(@PathVariable("id") String id){
        TourType tourist = service.get(id);
        return service.edit(tourist);
    }

    @PostMapping("/update")
    TourType updateTourTypePost(@RequestBody TourType tourist){
        this.service.save(tourist);
        return service.edit(tourist);
    }

    @RequestMapping("/delete/{id}")
    TourType delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
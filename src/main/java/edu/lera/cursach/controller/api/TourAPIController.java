package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Tour;
import edu.lera.cursach.model.Tour;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.tour.impls.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class TourAPIController {
    @Autowired
    TourServiceImpl service;

    @RequestMapping("/get/list")
    List<Tour> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Tour getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Tour create(@RequestBody Tour tour) {
        return service.save(tour);
    }


    @RequestMapping("/get-by-name/{name}")
    Tour getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Tour> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }


    @RequestMapping("/create/{name}")
    Tour createTour(@PathVariable("name") String name){
        return service.save(new Tour( Math.random() + name, name, "----", null,
                null, 0.0, 0.0, "----", "----",  LocalDateTime.now(), null,
                null, LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    Tour updateTour(@PathVariable("id") String id){
        Tour tour = service.get(id);
        return service.edit(tour);
    }

    @PostMapping("/update")
    Tour updateTourPost(@RequestBody Tour tour){
        this.service.save(tour);
        return service.edit(tour);
    }

    @RequestMapping("/delete/{id}")
    Tour delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
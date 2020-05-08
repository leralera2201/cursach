package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.PlannedTour;
import edu.lera.cursach.service.plannedTour.impls.PlannedTourServiceImpl;
import edu.lera.cursach.service.tour.impls.TourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/planned-tour")
public class PlannedTourAPIController {
    @Autowired
    PlannedTourServiceImpl service;

    @Autowired
    TourServiceImpl tourService;

    @RequestMapping("/get/list")
    List<PlannedTour> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    PlannedTour getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    PlannedTour create(@RequestBody PlannedTour plannedTour) {
        return service.save(plannedTour);
    }

    @RequestMapping("/get-by-name/{name}")
    PlannedTour getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<PlannedTour> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }

    @RequestMapping("/create/{id}")
    PlannedTour createPlannedTour(@PathVariable("id") String id){
        return service.save(new PlannedTour( Math.random() + id, tourService.get(id), "----", "----",
                LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    PlannedTour updatePlannedTour(@PathVariable("id") String id){
        PlannedTour plannedTour = service.get(id);
        return service.edit(plannedTour);
    }

    @PostMapping("/update")
    PlannedTour updatePlannedTourPost(@RequestBody PlannedTour plannedTour){
        this.service.save(plannedTour);
        return service.edit(plannedTour);
    }


    @RequestMapping("/delete/{id}")
    PlannedTour delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
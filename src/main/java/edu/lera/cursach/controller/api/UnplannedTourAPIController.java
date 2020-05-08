package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.UnplannedTour;
import edu.lera.cursach.service.tour.impls.TourServiceImpl;
import edu.lera.cursach.service.unplannedTour.impls.UnplannedTourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/unplanned-tour")
public class UnplannedTourAPIController {
    @Autowired
    UnplannedTourServiceImpl service;

    @Autowired
    TourServiceImpl tourService;

    @RequestMapping("/get/list")
    List<UnplannedTour> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    UnplannedTour getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    UnplannedTour create(@RequestBody UnplannedTour unplannedTour) {
        return service.save(unplannedTour);
    }

    @RequestMapping("/get-by-name/{name}")
    UnplannedTour getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<UnplannedTour> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }


    @RequestMapping("/create/{id}")
    UnplannedTour createUnplannedTour(@PathVariable("id") String id){
        return service.save(new UnplannedTour( Math.random() + id, tourService.get(id),
                LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    UnplannedTour updateUnplannedTour(@PathVariable("id") String id){
        UnplannedTour unplannedTour = service.get(id);
        return service.edit(unplannedTour);
    }

    @PostMapping("/update")
    UnplannedTour updateUnplannedTourPost(@RequestBody UnplannedTour unplannedTour){
        this.service.save(unplannedTour);
        return service.edit(unplannedTour);
    }
    @RequestMapping("/delete/{id}")
    UnplannedTour delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
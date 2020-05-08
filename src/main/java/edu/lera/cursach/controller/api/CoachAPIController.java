package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Coach;
import edu.lera.cursach.service.coach.impls.CoachServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/coach")
public class CoachAPIController {
    @Autowired
    CoachServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;

    @RequestMapping("/get/list")
    List<Coach> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Coach getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Coach create(@RequestBody Coach coach) {
        return service.save(coach);
    }

    @RequestMapping("/get-by-name/{name}")
    Coach getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Coach> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }

    @RequestMapping("/create/{id}")
    Coach createCoach(@PathVariable("id") String id){
        return service.save(new Coach( Math.random() + touristService.get(id).getSurname(),
                "----", touristService.get(id), 0.0, LocalDate.now(), LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    Coach updateCoach(@PathVariable("id") String id){
        Coach coach = service.get(id);
        return service.edit(coach);
    }

    @PostMapping("/update")
    Coach updateCoachPost(@RequestBody Coach coach){
        this.service.save(coach);
        return service.edit(coach);
    }


    @RequestMapping("/delete/{id}")
    Coach delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
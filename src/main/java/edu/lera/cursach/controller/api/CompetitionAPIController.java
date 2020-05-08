package edu.lera.cursach.controller.api;


import edu.lera.cursach.model.Competition;
import edu.lera.cursach.service.competition.impls.CompetitionServiceImpl;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/competition")
public class CompetitionAPIController {
    @Autowired
    CompetitionServiceImpl service;

    @RequestMapping("/get/list")
    List<Competition> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Competition getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Competition create(@RequestBody Competition competition) {
        return service.save(competition);
    }
    
    @RequestMapping("/get-by-name/{name}")
    Competition getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Competition> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }


    @RequestMapping("/create/{name}")
    Competition createCompetition(@PathVariable("name") String name){
        return service.save(new Competition(Math.random() + name, name, "----", null,
              LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now()
                ));
    }
    @RequestMapping("/update/{id}")
    Competition updateCompetition(@PathVariable("id") String id){
        Competition competition = service.get(id);
        return service.edit(competition);
    }

    @PostMapping("/update")
    Competition updateCompetitionPost(@RequestBody Competition competition){
        this.service.save(competition);
        return service.edit(competition);
    }


    @RequestMapping("/delete/{id}")
    Competition delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
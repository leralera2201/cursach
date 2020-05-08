package edu.lera.cursach.controller.api;


import edu.lera.cursach.model.ParticipationInCompetition;
import edu.lera.cursach.service.competition.impls.CompetitionServiceImpl;
import edu.lera.cursach.service.participationInCompetition.impls.ParticipationInCompetitionServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/participation-in-competition")
public class ParticipationInCompetitionAPIController {
    @Autowired
    ParticipationInCompetitionServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;

    @Autowired
    CompetitionServiceImpl competitionService;

    @RequestMapping("/get/list")
    List<ParticipationInCompetition> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    ParticipationInCompetition getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ParticipationInCompetition create(@RequestBody ParticipationInCompetition participationInCompetition) {
        return service.save(participationInCompetition);
    }
    @RequestMapping("/get-by-competition-name/{name}")
    ParticipationInCompetition getByCompetitionName(@PathVariable("name") String name){
        return service.getByCompetitionName(name);
    }
    @RequestMapping("/get-by-tourist-name/{name}")
    ParticipationInCompetition getByTouristName(@PathVariable("name") String name){
        return service.getByTouristName(name);
    }
    @RequestMapping("/get-all-by-competition-name/{name}")
    List<ParticipationInCompetition> getAllByCompetitionName(@PathVariable("name") String name){
        return service.getAllByCompetitionName(name);
    }
    @RequestMapping("/get-all-by-tourist-name/{name}")
    List<ParticipationInCompetition> getAllByTouristName(@PathVariable("name") String name){
        return service.getAllByTouristName(name);
    }

    @RequestMapping("/create/{tId}/{cId}")
    ParticipationInCompetition createParticipationInCompetition(@PathVariable("tId") String tId,
                          @PathVariable("cId") String cId){
        return service.save(new ParticipationInCompetition( Math.random() + tId + cId, competitionService.get(cId),
                touristService.get(tId), LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    ParticipationInCompetition updateParticipationInCompetition(@PathVariable("id") String id){
        ParticipationInCompetition participationInCompetition = service.get(id);
        return service.edit(participationInCompetition);
    }

    @PostMapping("/update")
    ParticipationInCompetition updateParticipationInCompetitionPost(@RequestBody ParticipationInCompetition participationInCompetition){
        this.service.save(participationInCompetition);
        return service.edit(participationInCompetition);
    }

    @RequestMapping("/delete/{id}")
    ParticipationInCompetition delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
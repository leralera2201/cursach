package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.ParticipationInTour;
import edu.lera.cursach.service.tour.impls.TourServiceImpl;
import edu.lera.cursach.service.participationInTour.impls.ParticipationInTourServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/participation-in-tour")
public class ParticipationInTourAPIController {
    @Autowired
    ParticipationInTourServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;

    @Autowired
    TourServiceImpl tourService;

    @RequestMapping("/get/list")
    List<ParticipationInTour> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    ParticipationInTour getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ParticipationInTour create(@RequestBody ParticipationInTour participationInTour) {
        return service.save(participationInTour);
    }
    @RequestMapping("/get-by-tour-name/{name}")
    ParticipationInTour getByTourName(@PathVariable("name") String name){
        return service.getByTourName(name);
    }
    @RequestMapping("/get-by-tourist-name/{name}")
    ParticipationInTour getByTouristName(@PathVariable("name") String name){
        return service.getByTouristName(name);
    }
    @RequestMapping("/get-all-by-tour-name/{name}")
    List<ParticipationInTour> getAllByTourName(@PathVariable("name") String name){
        return service.getAllByTourName(name);
    }
    @RequestMapping("/get-all-by-tourist-name/{name}")
    List<ParticipationInTour> getAllByTouristName(@PathVariable("name") String name){
        return service.getAllByTouristName(name);
    }

    @RequestMapping("/create/{tId}/{tstId}")
    ParticipationInTour createParticipationInTour(@PathVariable("tId") String tId,
                                                                @PathVariable("tstId") String tstId){
        return service.save(new ParticipationInTour( Math.random() + tId + tstId, tourService.get(tId),
                touristService.get(tstId), LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    ParticipationInTour updateParticipationInTour(@PathVariable("id") String id){
        ParticipationInTour participationInTour = service.get(id);
        return service.edit(participationInTour);
    }

    @PostMapping("/update")
    ParticipationInTour updateParticipationInTourPost(@RequestBody ParticipationInTour participationInTour){
        this.service.save(participationInTour);
        return service.edit(participationInTour);
    }

    @RequestMapping("/delete/{id}")
    ParticipationInTour delete(@PathVariable("id") String id) {
        return service.delete(id);
    }


}
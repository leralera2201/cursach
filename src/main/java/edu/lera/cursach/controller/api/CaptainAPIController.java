package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Captain;
import edu.lera.cursach.model.Captain;
import edu.lera.cursach.service.captain.impls.CaptainServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/captain")
public class CaptainAPIController {
    @Autowired
    CaptainServiceImpl service;

    @RequestMapping("/get/list")
    List<Captain> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Captain getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping("/get-by-name/{name}")
    Captain getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Captain> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Captain create(@RequestBody Captain captain) {
        return service.save(captain);
    }

    @RequestMapping("/create/{name}/{surname}")
    Captain createCaptain(@PathVariable("name") String name,
                          @PathVariable("surname") String surname){
        return service.save(new Captain( Math.random() + surname, surname, name, "----",
                LocalDate.now(), LocalDate.now(), 0.0, "----",
                "----", LocalDateTime.now(), LocalDateTime.now(), false
        ));
    }
    @RequestMapping("/update/{id}")
    Captain updateCaptain(@PathVariable("id") String id){
        Captain captain = service.get(id);
        return service.edit(captain);
    }

    @PostMapping("/update")
    Captain updateCaptainPost(@RequestBody Captain captain){
        this.service.save(captain);
        return service.edit(captain);
    }


    @RequestMapping("/delete/{id}")
    Captain delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
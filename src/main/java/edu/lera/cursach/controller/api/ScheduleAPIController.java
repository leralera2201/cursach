package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Schedule;
import edu.lera.cursach.service.schedule.impls.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleAPIController {
    @Autowired
    ScheduleServiceImpl service;



    @RequestMapping("/get/list")
    List<Schedule> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Schedule getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Schedule create(@RequestBody Schedule schedule) {
        return service.save(schedule);
    }
    @RequestMapping("/get-by-name/{name}")
    Schedule getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Schedule> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }


    @RequestMapping("/create/{name}")
    Schedule createSchedule(@PathVariable("name") String name){
        return service.save(new Schedule( Math.random() + name, LocalDateTime.now(),
                0.0, name, "----", 0.0, null, "----", LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    Schedule updateSchedule(@PathVariable("id") String id){
        Schedule schedule = service.get(id);
        return service.edit(schedule);
    }

    @PostMapping("/update")
    Schedule updateSchedulePost(@RequestBody Schedule schedule){
        this.service.save(schedule);
        return service.edit(schedule);
    }

    @RequestMapping("/delete/{id}")
    Schedule delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
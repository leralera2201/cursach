package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Group;

import edu.lera.cursach.service.captain.impls.CaptainServiceImpl;
import edu.lera.cursach.service.coach.impls.CoachServiceImpl;
import edu.lera.cursach.service.group.impls.GroupServiceImpl;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupAPIController {
    @Autowired
    GroupServiceImpl service;


    @RequestMapping("/get/list")
    List<Group> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Group getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Group create(@RequestBody Group group) {
        return service.save(group);
    }

    @RequestMapping("/get-by-name/{name}")
    Group getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Group> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }

    @RequestMapping("/create/{name}")
    Group createGroup(@PathVariable("name") String name){
        return service.save(new Group( Math.random() + name,  name, "----", LocalDateTime.now(), LocalDateTime.now(),
               null, null, null
        ));
    }
    @RequestMapping("/update/{id}")
    Group updateGroup(@PathVariable("id") String id){
        Group group = service.get(id);
        return service.edit(group);
    }

    @PostMapping("/update")
    Group updateGroupPost(@RequestBody Group group){
        this.service.save(group);
        return service.edit(group);
    }


    @RequestMapping("/delete/{id}")
    Group delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
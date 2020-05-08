package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Section;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/section")
public class SectionAPIController {
    @Autowired
    SectionServiceImpl service;

    @RequestMapping("/get/list")
    List<Section> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    Section getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Section create(@RequestBody Section section) {
        return service.save(section);
    }


    @RequestMapping("/get-by-name/{name}")
    Section getByName(@PathVariable("name") String name){
        return service.getByName(name);
    }
    @RequestMapping("/get-all-by-name/{name}")
    List<Section> getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }

    @RequestMapping("/create/{name}")
    Section createSection(@PathVariable("name") String name
                         ){
        return service.save(new Section( Math.random() + name, name, "----", null,
                LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    Section updateSection(@PathVariable("id") String id){
        Section section = service.get(id);
        return service.edit(section);
    }

    @PostMapping("/update")
    Section updateSectionPost(@RequestBody Section section){
        this.service.save(section);
        return service.edit(section);
    }

    @RequestMapping("/delete/{id}")
    Section delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
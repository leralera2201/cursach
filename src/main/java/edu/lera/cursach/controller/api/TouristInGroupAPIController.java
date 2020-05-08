package edu.lera.cursach.controller.api;

import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.TouristInGroup;
import edu.lera.cursach.model.TouristInGroup;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.group.impls.GroupServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import edu.lera.cursach.service.touristInGroup.impls.TouristInGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tourist-in-group")
public class TouristInGroupAPIController {
    @Autowired
    TouristInGroupServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;

    @Autowired
    GroupServiceImpl groupService;

    @RequestMapping("/get/list")
    List<TouristInGroup> getAll() {
        return service.getAll();
    }

    @RequestMapping("/get/{id}")
    TouristInGroup getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    TouristInGroup create(@RequestBody TouristInGroup touristInGroup) {
        return service.save(touristInGroup);
    }

    @RequestMapping("/get-by-group-name/{name}")
    TouristInGroup getByGroupName(@PathVariable("name") String name){
        return service.getByGroupName(name);
    }
    @RequestMapping("/get-by-tourist-name/{name}")
    TouristInGroup getByTouristName(@PathVariable("name") String name){
        return service.getByTouristName(name);
    }
    @RequestMapping("/get-all-by-group-name/{name}")
    List<TouristInGroup> getAllByGroupName(@PathVariable("name") String name){
        return service.getAllByGroupName(name);
    }
    @RequestMapping("/get-all-by-tourist-name/{name}")
    List<TouristInGroup> getAllByTouristName(@PathVariable("name") String name){
        return service.getAllByTouristName(name);
    }

    @RequestMapping("/create/{tId}/{gId}")
    TouristInGroup createTouristInGroup(@PathVariable("tId") String tId,
                                                  @PathVariable("gId") String gId){
        return service.save(new TouristInGroup( Math.random() + tId + gId, groupService.get(gId),
                touristService.get(tId), LocalDateTime.now(), LocalDateTime.now()
        ));
    }
    @RequestMapping("/update/{id}")
    TouristInGroup updateTouristInGroup(@PathVariable("id") String id){
        TouristInGroup touristInGroup = service.get(id);
        return service.edit(touristInGroup);
    }

    @PostMapping("/update")
    TouristInGroup updateTouristInGroupPost(@RequestBody TouristInGroup touristInGroup){
        this.service.save(touristInGroup);
        return service.edit(touristInGroup);
    }

    @RequestMapping("/delete/{id}")
    TouristInGroup delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
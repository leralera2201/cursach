package edu.lera.cursach.controller.web;

//import edu.lera.cursach.form.TouristInGroupForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.TouristInGroupForm;
import edu.lera.cursach.model.*;
import edu.lera.cursach.service.captain.impls.CaptainServiceImpl;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.coach.impls.CoachServiceImpl;
import edu.lera.cursach.service.group.impls.GroupServiceImpl;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import edu.lera.cursach.service.touristInGroup.impls.TouristInGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/tourist-in-group")
public class TouristInGroupWEBController {
    @Autowired
    TouristInGroupServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;
    @Autowired
    GroupServiceImpl groupService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("touristInGroups", service.getAll());
        return "touristInGroupList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<TouristInGroup> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("touristInGroups", list);
        return "touristInGroupList";
    }
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<TouristInGroup> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("touristInGroups", list);
        return "touristInGroupList";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-tourist", method = RequestMethod.GET)
    String sortByTourist(Model model){
        List<TouristInGroup> list = service.sortByTouristName();
        model.addAttribute("touristInGroups", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "touristInGroupList";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-tourist", method = RequestMethod.POST)
    public String searchSortedByTourist(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<TouristInGroup> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("touristInGroups", list);
        return "touristInGroupList";
    }


    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-group", method = RequestMethod.GET)
    String sortByCompetition(Model model){
        List<TouristInGroup> list = service.sortByGroupName();
        model.addAttribute("touristInGroups", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "touristInGroupList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-group", method = RequestMethod.POST)
    public String searchSortedByCompetition(Model model,
                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<TouristInGroup> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("touristInGroups", list);
        return "touristInGroupList";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("touristInGroups", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/tourist-in-group/list";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        TouristInGroupForm touristInGroupForm = new TouristInGroupForm();

        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        Map<String, String> mavs2 = groupService.getAll().stream()
                .collect(Collectors.toMap(Group::getId, Group::getGroup_name));

        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);

        model.addAttribute("touristInGroupForm", touristInGroupForm);
        return "touristInGroupAdd";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("touristInGroupForm") TouristInGroupForm touristInGroupForm){

        Tourist tourist = touristService.get(touristInGroupForm.getTourist());
        Group group = groupService.get(touristInGroupForm.getGroup());


        TouristInGroup touristInGroup = new TouristInGroup();
        touristInGroup.setGroup(group);
        touristInGroup.setTourist(tourist);

        service.save(touristInGroup);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("touristInGroups", service.getAll());
        return "redirect:/web/tourist-in-group/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        TouristInGroup touristInGroup = service.get(id);
        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        Map<String, String> mavs2 = groupService.getAll().stream()
                .collect(Collectors.toMap(Group::getId, Group::getGroup_name));
        TouristInGroupForm touristInGroupForm = new TouristInGroupForm();
        touristInGroupForm.setId(touristInGroup.getId());
        touristInGroupForm.setGroup(touristInGroup.getGroup().getGroup_name());
        touristInGroupForm.setTourist(touristInGroup.getTourist().getName());

        model.addAttribute("touristInGroupForm", touristInGroupForm);
        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);
        return "touristInGroupEdit";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("touristInTouristInGroupForm") TouristInGroupForm touristInGroupForm,
                       @PathVariable("id") String id){

        TouristInGroup touristInGroup = new TouristInGroup();
        Tourist tourist = touristService.get(touristInGroupForm.getTourist());
        Group group = groupService.get(touristInGroupForm.getGroup());

        touristInGroup.setId(touristInGroupForm.getId());
        touristInGroup.setGroup(group);
        touristInGroup.setTourist(tourist);

        service.save(touristInGroup);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("touristInGroupForm", touristInGroupForm);
        return "redirect:/web/tourist-in-group/list";
    }



}

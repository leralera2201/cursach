package edu.lera.cursach.controller.web;

//import edu.lera.cursach.form.GroupForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.GroupForm;
import edu.lera.cursach.model.*;
import edu.lera.cursach.service.captain.impls.CaptainServiceImpl;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.coach.impls.CoachServiceImpl;
import edu.lera.cursach.service.group.impls.GroupServiceImpl;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
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
@RequestMapping("/web/group")
public class GroupWEBController {
    @Autowired
    GroupServiceImpl service;

    @Autowired
    SectionServiceImpl sectionService;
    @Autowired
    CoachServiceImpl coachService;
    @Autowired
    CaptainServiceImpl captainService;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("groups", service.getAll());
        return "groupList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Group> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("groups", list);
        return "groupList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Group> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("groups", list);
        return "groupList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Group> list = service.sortByName();
        model.addAttribute("groups", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "groupList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Group> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("groups", list);
        return "groupList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("groups", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/group/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        GroupForm groupForm = new GroupForm();

        Map<String, String> mavs = sectionService.getAll().stream()
                .collect(Collectors.toMap(Section::getId, Section::getSection_name));
        Map<String, String> mavs2 = coachService.getAll().stream()
                .collect(Collectors.toMap(Coach::getId, Coach::getTouristNameAndSurname));
        Map<String, String> mavs3 = captainService.getAll().stream()
                .collect(Collectors.toMap(Captain::getId, Captain::getNameAndSurname));

        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("mavs3", mavs3);
        model.addAttribute("groupForm", groupForm);
        return "groupAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("groupForm") GroupForm groupForm){

        Section section = sectionService.get(groupForm.getSection());
        Captain captain = captainService.get(groupForm.getAssigned_by());
        Coach coach = coachService.get(groupForm.getCoach());

        Group group = new Group();
        group.setGroup_name(groupForm.getGroup_name());
        group.setDescription(groupForm.getDescription());
        group.setAssigned_by(captain);
        group.setCoach(coach);
        group.setSection(section);
        service.save(group);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("groups", service.getAll());
        return "redirect:/web/group/list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        Group group = service.get(id);
        Map<String, String> mavs = sectionService.getAll().stream()
                .collect(Collectors.toMap(Section::getId, Section::getSection_name));
        Map<String, String> mavs2 = coachService.getAll().stream()
                .collect(Collectors.toMap(Coach::getId, Coach::getTouristNameAndSurname));
        Map<String, String> mavs3 = captainService.getAll().stream()
                .collect(Collectors.toMap(Captain::getId, Captain::getNameAndSurname));


        GroupForm groupForm = new GroupForm();
        groupForm.setId(group.getId());
        groupForm.setGroup_name(group.getGroup_name());
        groupForm.setDescription(group.getDescription());
        groupForm.setAssigned_by(group.getAssigned_by().getNameAndSurname());
        groupForm.setCoach(group.getCoach().getTouristNameAndSurname());
        groupForm.setSection(group.getSection().getSection_name());

        model.addAttribute("groupForm", groupForm);
        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("mavs3", mavs3);
        return "groupAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("groupForm") GroupForm groupForm,
                       @PathVariable("id") String id){

        Group group = new Group();
        Section section = sectionService.get(groupForm.getSection());
        Captain captain = captainService.get(groupForm.getAssigned_by());
        Coach coach = coachService.get(groupForm.getCoach());

        group.setId(groupForm.getId());
        group.setGroup_name(groupForm.getGroup_name());
        group.setDescription(groupForm.getDescription());
        group.setSection(section);
        group.setCoach(coach);
        group.setAssigned_by(captain);

        service.save(group);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("groupForm", groupForm);
        return "redirect:/web/group/list";
    }



}

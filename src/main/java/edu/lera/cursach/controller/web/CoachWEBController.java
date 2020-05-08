package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.CoachForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.model.Coach;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.coach.impls.CoachServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/coach")
public class CoachWEBController {
    @Autowired
    CoachServiceImpl service;
    @Autowired
    TouristServiceImpl touristService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("coaches", service.getAll());
        return "coachList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Coach> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("coaches", list);
        return "coachList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Coach> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("coaches", list);
        return "coachList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Coach> list = service.sortByName();
        model.addAttribute("coaches", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "coachList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Coach> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("coaches", list);
        return "coachList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("coaches", service.getAll());
        return "coachList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CoachForm coachForm = new CoachForm();
        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname
                ));

        model.addAttribute("mavs", mavs);
        model.addAttribute("coachForm", coachForm);
        return "coachAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("coachForm") CoachForm coachForm) {
        Coach coach = new Coach();
        Tourist tourist = touristService.get(coachForm.getTourist());
        coach.setSalary(Double.parseDouble(coachForm.getSalary()));
        coach.setSpeciality(coachForm.getSpeciality());
        coach.setStarted_work_year(LocalDate.parse(coachForm.getStarted_work_year(), formatter));
        coach.setTourist(tourist);
        service.save(coach);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("coaches", service.getAll());
        return "redirect:/web/coach/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Coach coach = service.get(id);
        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        CoachForm coachForm = new CoachForm();
        coachForm.setSalary(coach.getSalary().toString());
        coachForm.setSpeciality(coach.getSpeciality());
        coachForm.setStarted_work_year(coach.getStarted_work_year().toString());
        coachForm.setTourist(coach.getTourist().getName());

        model.addAttribute("coachForm", coachForm);
        model.addAttribute("mavs", mavs);
        return "coachAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("coachForm") CoachForm coachForm) {
        Coach coach = new Coach();
        coach.setId(id);
        Tourist tourist = touristService.get(coachForm.getTourist());
        coach.setSalary(Double.parseDouble(coachForm.getSalary()));
        coach.setSpeciality(coachForm.getSpeciality());
        coach.setStarted_work_year(LocalDate.parse(coachForm.getStarted_work_year(), formatter));
        coach.setTourist(tourist);
        service.save(coach);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("coaches", service.getAll());
        return "redirect:/web/coach/list";
    }

}

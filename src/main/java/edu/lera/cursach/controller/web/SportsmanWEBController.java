package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.SportsmanForm;
import edu.lera.cursach.model.Sportsman;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.sportsman.impls.SportsmanServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/sportsman")
public class SportsmanWEBController {
    @Autowired
    SportsmanServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("sportsmen", service.getAll());
        return "sportsmanList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Sportsman> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sportsmen", list);
        return "sportsmanList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Sportsman> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sportsmen", list);
        return "sportsmanList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Sportsman> list = service.sortByName();
        model.addAttribute("sportsmen", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "sportsmanList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Sportsman> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sportsmen", list);
        return "sportsmanList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("sportsmen", service.getAll());
        return "sportsmanList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        SportsmanForm sportsmanForm = new SportsmanForm();
        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));

        model.addAttribute("mavs", mavs);
        model.addAttribute("sportsmanForm", sportsmanForm);
        return "sportsmanAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("sportsmanForm") SportsmanForm sportsmanForm) {
        Sportsman sportsman = new Sportsman();
        Tourist tourist = touristService.get(sportsmanForm.getTourist());
        sportsman.setSport_kinds(sportsmanForm.getSport_kinds());
        sportsman.setTourist(tourist);

        service.save(sportsman);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sportsmen", service.getAll());
        return "redirect:/web/sportsman/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Sportsman sportsman = service.get(id);
        SportsmanForm sportsmanForm = new SportsmanForm();
        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        sportsmanForm.setSport_kinds(sportsman.getSport_kinds());
        sportsmanForm.setTourist(sportsman.getTourist().getName());
        model.addAttribute("sportsmanForm", sportsmanForm);
        model.addAttribute("mavs", mavs);
        return "sportsmanAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("sportsmanForm") SportsmanForm sportsmanForm) {
        Sportsman sportsman = new Sportsman();
        sportsman.setId(id);
        Tourist tourist = touristService.get(sportsmanForm.getTourist());
        sportsman.setSport_kinds(sportsmanForm.getSport_kinds());
        sportsman.setTourist(tourist);

        service.save(sportsman);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sportsmen", service.getAll());
        return "redirect:/web/sportsman/list";
    }

}

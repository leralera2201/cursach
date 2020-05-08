package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.AmatorForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.model.Amator;
import edu.lera.cursach.model.Tour;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.amator.impls.AmatorServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
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
@RequestMapping("/web/amator")
public class AmatorWEBController {
    @Autowired
    AmatorServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("amators", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "amatorList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Amator> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("amators", list);
        return "amatorList";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Amator> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("amators", list);
        return "amatorList";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Amator> list = service.sortByName();
        model.addAttribute("amators", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "amatorList";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Amator> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("amators", list);
        return "amatorList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("amators", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/amator/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        AmatorForm amatorForm = new AmatorForm();

        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname
                ));

        model.addAttribute("mavs", mavs);
        model.addAttribute("amatorForm", amatorForm);
        return "amatorAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("amatorForm") AmatorForm amatorForm){

        Tourist tourist = touristService.get(amatorForm.getTourist());


        Amator newAmator = new Amator(amatorForm.getId(), amatorForm.getHobbies(), tourist,
                LocalDateTime.now(), LocalDateTime.now());
        service.save(newAmator);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("amators", service.getAll());
        return "redirect:/web/amator/list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        Amator amator = service.get(id);
        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));


        AmatorForm amatorForm = new AmatorForm();
        amatorForm.setId(amator.getId());
        amatorForm.setHobbies(amator.getHobbies());
        amatorForm.setTourist(amator.getTourist().getName());
        model.addAttribute("amatorForm", amatorForm);
        model.addAttribute("mavs", mavs);
        return "amatorAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("amatorForm") AmatorForm amatorForm,
                       @PathVariable("id") String id){

        Amator amator = new Amator();
        Tourist tourist = touristService.get(amatorForm.getTourist());

        amator.setId(amatorForm.getId());
        amator.setHobbies(amatorForm.getHobbies());
        amator.setTourist(tourist);
        service.save(amator);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("amatorForm", amatorForm);
        return "redirect:/web/amator/list";
    }

}

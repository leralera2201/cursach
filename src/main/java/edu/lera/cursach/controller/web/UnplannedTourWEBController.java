package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.UnplannedTourForm;
import edu.lera.cursach.model.*;
import edu.lera.cursach.service.tour.impls.TourServiceImpl;
import edu.lera.cursach.service.unplannedTour.impls.UnplannedTourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/unplanned-tour")
public class UnplannedTourWEBController {
    @Autowired
    UnplannedTourServiceImpl service;

    @Autowired
    TourServiceImpl tourService;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("unplannedTours", service.getAll());
        return "unplannedTourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<UnplannedTour> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("unplannedTours", list);
        return "unplannedTourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<UnplannedTour> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("unplannedTours", list);
        return "unplannedTourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<UnplannedTour> list = service.sortByDate();
        model.addAttribute("unplannedTours", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "unplannedTourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<UnplannedTour> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("unplannedTours", list);
        return "unplannedTourList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("unplannedTours", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/unplannedTour/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        UnplannedTourForm unplannedTourForm = new UnplannedTourForm();

        Map<String, String> mavs = tourService.getAll().stream()
                .collect(Collectors.toMap(Tour::getId, Tour::getTour_name));

        model.addAttribute("mavs", mavs);

        model.addAttribute("unplannedTourForm", unplannedTourForm);
        return "unplannedTourAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("unplannedTourForm") UnplannedTourForm unplannedTourForm){

        Tour tour = tourService.get(unplannedTourForm.getTour());

        UnplannedTour unplannedTour = new UnplannedTour();
        unplannedTour.setTour(tour);

        service.save(unplannedTour);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("unplannedTours", service.getAll());
        return "redirect:/web/unplannedTour/list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        UnplannedTour unplannedTour = service.get(id);
        Map<String, String> mavs = tourService.getAll().stream()
                .collect(Collectors.toMap(Tour::getId, Tour::getTour_name));


        UnplannedTourForm unplannedTourForm = new UnplannedTourForm();
        unplannedTourForm.setId(unplannedTour.getId());
        unplannedTourForm.setTour(unplannedTour.getTour().getTour_name());


        model.addAttribute("unplannedTourForm", unplannedTourForm);
        model.addAttribute("mavs", mavs);

        return "unplannedTourAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("unplannedTourForm") UnplannedTourForm unplannedTourForm,
                       @PathVariable("id") String id){

        Tour tour = tourService.get(unplannedTourForm.getTour());

        UnplannedTour unplannedTour = new UnplannedTour();
        unplannedTour.setTour(tour);
        unplannedTour.setId(unplannedTourForm.getId());

        service.save(unplannedTour);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("unplannedTourForm", unplannedTourForm);
        return "redirect:/web/unplannedTour/list";
    }



}

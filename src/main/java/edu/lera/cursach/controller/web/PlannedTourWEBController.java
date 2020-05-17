package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.PlannedTourForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.model.*;
import edu.lera.cursach.service.plannedTour.impls.PlannedTourServiceImpl;
import edu.lera.cursach.service.tour.impls.TourServiceImpl;
import edu.lera.cursach.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/planned-tour")
public class PlannedTourWEBController {
    @Autowired
    PlannedTourServiceImpl service;

    @Autowired
    TourServiceImpl tourService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("plannedTours", service.getAll());
        return "plannedTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<PlannedTour> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("plannedTours", list);
        return "plannedTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<PlannedTour> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("plannedTours", list);
        return "plannedTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<PlannedTour> list = service.sortByDate();
        model.addAttribute("plannedTours", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "plannedTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<PlannedTour> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("plannedTours", list);
        return "plannedTourList";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("plannedTours", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/planned-tour/list";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        PlannedTourForm plannedTourForm = new PlannedTourForm();

        Map<String, String> mavs = tourService.getAll().stream()
                .collect(Collectors.toMap(Tour::getId, Tour::getTour_name));

        model.addAttribute("mavs", mavs);

        model.addAttribute("plannedTourForm", plannedTourForm);
        return "plannedTourAdd";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("plannedTourForm") PlannedTourForm plannedTourForm){

        Tour tour = tourService.get(plannedTourForm.getTour());

        PlannedTour plannedTour = new PlannedTour();
        Validation validation = new Validation();
        boolean vn = validation.validateStringField(plannedTourForm.getBreak_schedule());
        boolean vd = validation.validateStringField(plannedTourForm.getHalt_schedule());
        if (vn && vd) {
            plannedTour.setTour(tour);
            plannedTour.setBreak_schedule(plannedTourForm.getBreak_schedule());
            plannedTour.setHalt_schedule(plannedTourForm.getHalt_schedule());

            service.save(plannedTour);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("plannedTours", service.getAll());
            return "redirect:/web/planned-tour/list";
        }else {
            return "wrongData";
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        PlannedTour plannedTour = service.get(id);
        Map<String, String> mavs = tourService.getAll().stream()
                .collect(Collectors.toMap(Tour::getId, Tour::getTour_name));


        PlannedTourForm plannedTourForm = new PlannedTourForm();
        plannedTourForm.setId(plannedTour.getId());
        plannedTourForm.setTour(plannedTour.getTour().getTour_name());
        plannedTourForm.setBreak_schedule(plannedTour.getBreak_schedule());
        plannedTourForm.setHalt_schedule(plannedTour.getHalt_schedule());


        model.addAttribute("plannedTourForm", plannedTourForm);
        model.addAttribute("mavs", mavs);

        return "plannedTourEdit";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("plannedTourForm") PlannedTourForm plannedTourForm,
                       @PathVariable("id") String id){

        Tour tour = tourService.get(plannedTourForm.getTour());

        PlannedTour plannedTour = new PlannedTour();
        Validation validation = new Validation();
        boolean vn = validation.validateStringField(plannedTourForm.getBreak_schedule());
        boolean vd = validation.validateStringField(plannedTourForm.getHalt_schedule());
        if (vn && vd) {
            plannedTour.setTour(tour);
            plannedTour.setId(plannedTourForm.getId());
            plannedTour.setHalt_schedule(plannedTourForm.getHalt_schedule());
            plannedTour.setBreak_schedule(plannedTourForm.getBreak_schedule());

            service.save(plannedTour);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("plannedTourForm", plannedTourForm);
            return "redirect:/web/planned-tour/list";
        }else {
            return "wrongData";
        }

    }



}

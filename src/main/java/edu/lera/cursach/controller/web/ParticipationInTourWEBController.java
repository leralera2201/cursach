package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.ParticipationInTourForm;
import edu.lera.cursach.model.*;

import edu.lera.cursach.service.tour.impls.TourServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import edu.lera.cursach.service.participationInTour.impls.ParticipationInTourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/participation-in-tour")
public class ParticipationInTourWEBController {
    @Autowired
    ParticipationInTourServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;
    @Autowired
    TourServiceImpl tourService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("participationInTours", service.getAll());
        return "participationInTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<ParticipationInTour> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInTours", list);
        return "participationInTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<ParticipationInTour> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInTours", list);
        return "participationInTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-tourist", method = RequestMethod.GET)
    String sortByTourist(Model model){
        List<ParticipationInTour> list = service.sortByTouristName();
        model.addAttribute("participationInTours", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "participationInTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-tourist", method = RequestMethod.POST)
    public String searchSortedByTourist(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<ParticipationInTour> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInTours", list);
        return "participationInTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-tour", method = RequestMethod.GET)
    String sortByTour(Model model){
        List<ParticipationInTour> list = service.sortByTourName();
        model.addAttribute("participationInTours", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "participationInTourList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-tour", method = RequestMethod.POST)
    public String searchSortedByTour(Model model,
                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<ParticipationInTour> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInTours", list);
        return "participationInTourList";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("participationInTours", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/participation-in-tour/list";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        ParticipationInTourForm participationInTourForm = new ParticipationInTourForm();

        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        Map<String, String> mavs2 = tourService.getAll().stream()
                .collect(Collectors.toMap(Tour::getId, Tour::getTour_name));

        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);

        model.addAttribute("participationInTourForm", participationInTourForm);
        return "participationInTourAdd";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("participationInTourForm") ParticipationInTourForm participationInTourForm){

        Tourist tourist = touristService.get(participationInTourForm.getTourist());
        Tour tour = tourService.get(participationInTourForm.getTour());


        ParticipationInTour participationInTour = new ParticipationInTour();
        participationInTour.setTour(tour);
        participationInTour.setTourist(tourist);

        service.save(participationInTour);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInTours", service.getAll());
        return "redirect:/web/participation-in-tour/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        ParticipationInTour participationInTour = service.get(id);
        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        Map<String, String> mavs2 = tourService.getAll().stream()
                .collect(Collectors.toMap(Tour::getId, Tour::getTour_name));
        ParticipationInTourForm participationInTourForm = new ParticipationInTourForm();
        participationInTourForm.setId(participationInTour.getId());
        participationInTourForm.setTour(participationInTour.getTour().getTour_name());
        participationInTourForm.setTourist(participationInTour.getTourist().getName());

        model.addAttribute("participationInTourForm", participationInTourForm);
        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);
        return "participationInTourEdit";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("touristInParticipationInTourForm") ParticipationInTourForm participationInTourForm,
                       @PathVariable("id") String id){

        ParticipationInTour participationInTour = new ParticipationInTour();
        Tourist tourist = touristService.get(participationInTourForm.getTourist());
        Tour tour = tourService.get(participationInTourForm.getTour());

        participationInTour.setId(participationInTourForm.getId());
        participationInTour.setTour(tour);
        participationInTour.setTourist(tourist);

        service.save(participationInTour);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInTourForm", participationInTourForm);
        return "redirect:/web/participation-in-tour/list";
    }



}

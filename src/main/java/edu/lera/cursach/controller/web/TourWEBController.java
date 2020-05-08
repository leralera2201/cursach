package edu.lera.cursach.controller.web;

//import edu.lera.cursach.form.TourForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.TourForm;
import edu.lera.cursach.model.*;
import edu.lera.cursach.service.captain.impls.CaptainServiceImpl;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.coach.impls.CoachServiceImpl;
import edu.lera.cursach.service.group.impls.GroupServiceImpl;
import edu.lera.cursach.service.tour.impls.TourServiceImpl;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
import edu.lera.cursach.service.tourType.impls.TourTypeServiceImpl;
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
@RequestMapping("/web/tour")
public class TourWEBController {
    @Autowired
    TourServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;
    @Autowired
    GroupServiceImpl groupService;
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    TourTypeServiceImpl tourTypeService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d H-m");
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("tours", service.getAll());
        return "tourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Tour> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tours", list);
        return "tourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Tour> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tours", list);
        return "tourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Tour> list = service.sortByName();
        model.addAttribute("tours", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "tourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Tour> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tours", list);
        return "tourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-date", method = RequestMethod.GET)
    String sortByDate(Model model){
        List<Tour> list = service.sortByDate();
        model.addAttribute("tours", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "tourList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-date", method = RequestMethod.POST)
    public String searchSortedByDate(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Tour> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tours", list);
        return "tourList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("tours", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/tour/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        TourForm tourForm = new TourForm();

        Map<String, String> mavs = categoryService.getAll().stream()
                .collect(Collectors.toMap(Category::getId, Category::getCategory_name));
        Map<String, String> mavs2 = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        Map<String, String> mavs3 = groupService.getAll().stream()
                .collect(Collectors.toMap(Group::getId, Group::getGroup_name));
        Map<String, String> mavs4 = tourTypeService.getAll().stream()
                .collect(Collectors.toMap(TourType::getId, TourType::getType_name));

        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("mavs3", mavs3);
        model.addAttribute("mavs4", mavs4);
        model.addAttribute("tourForm", tourForm);
        return "tourAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("tourForm") TourForm tourForm){

        Group group = groupService.get(tourForm.getGroup());
        TourType tourType = tourTypeService.get(tourForm.getTour_type());
        Category category = categoryService.get(tourForm.getCategory());
        Tourist tourist = touristService.get(tourForm.getInstructor());

        Tour tour = new Tour();
        tour.setTour_name(tourForm.getTour_name());
        tour.setTour_description(tourForm.getTour_description());
        tour.setTour_full_time(Double.parseDouble(tourForm.getTour_full_time()));
        tour.setTour_date(LocalDateTime.parse(tourForm.getTour_date(), formatter));
        tour.setRoute_length(tourForm.getRoute_length());
        tour.setRoute(tourForm.getRoute());
        tour.setPayment(Double.parseDouble(tourForm.getPayment()));
        tour.setCategory(category);
        tour.setGroup(group);
        tour.setTour_type(tourType);
        tour.setInstructor(tourist);
        service.save(tour);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tours", service.getAll());
        return "redirect:/web/tour/list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        Tour tour = service.get(id);
        Map<String, String> mavs = categoryService.getAll().stream()
                .collect(Collectors.toMap(Category::getId, Category::getCategory_name));
        Map<String, String> mavs2 = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        Map<String, String> mavs3 = groupService.getAll().stream()
                .collect(Collectors.toMap(Group::getId, Group::getGroup_name));
        Map<String, String> mavs4 = tourTypeService.getAll().stream()
                .collect(Collectors.toMap(TourType::getId, TourType::getType_name));



        TourForm tourForm = new TourForm();
        tourForm.setId(tour.getId());
        tourForm.setTour_name(tour.getTour_name());
        tourForm.setTour_description(tour.getTour_description());
        tourForm.setTour_full_time(tour.getTour_full_time().toString());
        tourForm.setTour_date(tour.getTour_date().toString());
        tourForm.setRoute_length(tour.getRoute_length());
        tourForm.setRoute(tour.getRoute());
        tourForm.setPayment(tour.getPayment().toString());
        tourForm.setCategory(tour.getCategory().getCategory_name());
        tourForm.setGroup(tour.getGroup().getGroup_name());
        tourForm.setTour_type(tour.getTour_type().getType_name());
        tourForm.setInstructor(tour.getInstructor().getNameandSurname());

        model.addAttribute("tourForm", tourForm);
        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);
        model.addAttribute("mavs3", mavs3);
        model.addAttribute("mavs4", mavs4);
        return "tourAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("tourForm") TourForm tourForm,
                       @PathVariable("id") String id){

        Tour tour = new Tour();
        Group group = groupService.get(tourForm.getGroup());
        TourType tourType = tourTypeService.get(tourForm.getTour_type());
        Category category = categoryService.get(tourForm.getCategory());
        Tourist tourist = touristService.get(tourForm.getInstructor());
        tour.setId(tourForm.getId());
        tour.setTour_name(tourForm.getTour_name());
        tour.setTour_description(tourForm.getTour_description());
        tour.setTour_full_time(Double.parseDouble(tourForm.getTour_full_time()));
        tour.setTour_date(LocalDateTime.parse(tourForm.getTour_date(), formatter));
        tour.setRoute_length(tourForm.getRoute_length());
        tour.setRoute(tourForm.getRoute());
        tour.setPayment(Double.parseDouble(tourForm.getPayment()));
        tour.setCategory(category);
        tour.setGroup(group);
        tour.setTour_type(tourType);
        tour.setInstructor(tourist);

        service.save(tour);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourForm", tourForm);
        return "redirect:/web/tour/list";
    }



}

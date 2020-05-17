package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.TourTypeForm;
import edu.lera.cursach.model.*;
import edu.lera.cursach.service.tourType.impls.TourTypeServiceImpl;
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
@RequestMapping("/web/tour-type")
public class TourTypeWEBController {
    @Autowired
    TourTypeServiceImpl service;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("tourTypes", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "tourTypeList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<TourType> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourTypes", list);
        return "tourTypeList";
    }
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<TourType> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourTypes", list);
        return "tourTypeList";
    }
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<TourType> list = service.sortByName();
        model.addAttribute("tourTypes", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "tourTypeList";
    }
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<TourType> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourTypes", list);
        return "tourTypeList";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("tourTypes", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/tour-type/list";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        TourTypeForm tourTypeForm = new TourTypeForm();

        model.addAttribute("tourTypeForm", tourTypeForm);
        return "tourTypeAdd";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("tourTypeForm") TourTypeForm tourTypeForm){

        TourType tourType = new TourType();
        Validation validation = new Validation();
        boolean vn = validation.validateName(tourTypeForm.getType_name());
        boolean vd = validation.validateStringField(tourTypeForm.getType_description());
        if (vn && vd ) {
            tourType.setType_description(tourTypeForm.getType_description());
            tourType.setType_name(tourTypeForm.getType_name());
            service.save(tourType);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("tourTypes", service.getAll());
            return "redirect:/web/tour-type/list";
        }else {
            return "wrongData";
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        TourType tourType = service.get(id);

        TourTypeForm tourTypeForm = new TourTypeForm();
        tourTypeForm.setId(tourType.getId());
        tourTypeForm.setType_description(tourType.getType_description());
        tourTypeForm.setType_name(tourType.getType_name());

        model.addAttribute("tourTypeForm", tourTypeForm);
        return "tourTypeEdit";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("tourTypeForm") TourTypeForm tourTypeForm,
                       @PathVariable("id") String id){

        TourType tourType = new TourType();
        Validation validation = new Validation();
        boolean vn = validation.validateName(tourTypeForm.getType_name());
        boolean vd = validation.validateStringField(tourTypeForm.getType_description());
        if (vn && vd ) {
            tourType.setId(tourTypeForm.getId());
            tourType.setType_name(tourTypeForm.getType_name());
            tourType.setType_description(tourTypeForm.getType_description());


            service.save(tourType);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("tourTypeForm", tourTypeForm);
            return "redirect:/web/tour-type/list";
        }else {
            return "wrongData";
        }

    }



}

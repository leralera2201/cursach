package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.SectionForm;
import edu.lera.cursach.model.Captain;
import edu.lera.cursach.model.Section;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.captain.impls.CaptainServiceImpl;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
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
@RequestMapping("/web/section")
public class SectionWEBController {
    @Autowired
    SectionServiceImpl service;
    @Autowired
    CaptainServiceImpl captainService;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("sections", service.getAll());
        return "sectionList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Section> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sections", list);
        return "sectionList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Section> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sections", list);
        return "sectionList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Section> list = service.sortByName();
        model.addAttribute("sections", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "sectionList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Section> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sections", list);
        return "sectionList";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("sections", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/section/list";

    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        SectionForm sectionForm = new SectionForm();
        Map<String, String> mavs = captainService.getAll().stream()
                .collect(Collectors.toMap(Captain::getId, Captain::getNameAndSurname));

        model.addAttribute("mavs", mavs);
        model.addAttribute("sectionForm", sectionForm);
        return "sectionAdd";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("sectionForm") SectionForm sectionForm) {
        Section section = new Section();
        Captain captain = captainService.get(sectionForm.getCaptain());
        Validation validation = new Validation();
        boolean vn = validation.validateName(sectionForm.getSection_name());
        boolean vd = validation.validateStringField(sectionForm.getDescription());

        if (vn && vd) {
            section.setSection_name(sectionForm.getSection_name());
            section.setDescription(sectionForm.getDescription());
            section.setCaptain(captain);
            service.save(section);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("sections", service.getAll());
            return "redirect:/web/section/list";
        }else {
            return "wrongData";
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Section section = service.get(id);
        Map<String, String> mavs = captainService.getAll().stream()
                .collect(Collectors.toMap(Captain::getId, Captain::getNameAndSurname));

        SectionForm sectionForm = new SectionForm();
        sectionForm.setSection_name(section.getSection_name());
        sectionForm.setDescription(section.getDescription());
        sectionForm.setCaptain(section.getCaptain().getName());
        model.addAttribute("sectionForm", sectionForm);
        model.addAttribute("mavs", mavs);
        return "sectionEdit";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("sectionForm") SectionForm sectionForm) {
        Section section = new Section();
        Validation validation = new Validation();
        boolean vn = validation.validateName(sectionForm.getSection_name());
        boolean vd = validation.validateStringField(sectionForm.getDescription());

        if (vn && vd) {
            section.setId(id);
            Captain captain = captainService.get(sectionForm.getCaptain());
            section.setSection_name(sectionForm.getSection_name());
            section.setDescription(sectionForm.getDescription());
            section.setCaptain(captain);
            service.save(section);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("sections", service.getAll());
            return "redirect:/web/section/list";
        }else {
            return "wrongData";
        }

    }

}

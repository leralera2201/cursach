package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.TouristForm;
import edu.lera.cursach.model.Captain;
import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import edu.lera.cursach.validation.Validation;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/tourist")
public class TouristWEBController {
    @Autowired
    TouristServiceImpl service;

    @Autowired
    CategoryServiceImpl categoryService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("tourists", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "touristList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Tourist> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourists", list);
        return "touristList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Tourist> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourists", list);
        return "touristList";
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Tourist> list = service.sortByName();
        model.addAttribute("tourists", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "touristList";
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Tourist> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourists", list);
        return "touristList";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("tourists", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/tourist/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        TouristForm touristForm = new TouristForm();

        Map<String, String> mavs = categoryService.getAll().stream()
                .collect(Collectors.toMap(Category::getId, Category::getCategory_name));

        model.addAttribute("mavs", mavs);
        model.addAttribute("touristForm", touristForm);
        return "touristAdd";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                             @ModelAttribute("touristForm") TouristForm touristForm){

        Category category = categoryService.get(touristForm.getMax_category());
        Validation validation = new Validation();
        boolean vd = validation.validateDate(touristForm.getBirthday());
        boolean ve = validation.validateEmail(touristForm.getEmail());
        boolean vn = validation.validateName(touristForm.getName());
        boolean vs = validation.validateName(touristForm.getSurname());
        boolean vp = validation.validateName(touristForm.getPatronic());
        boolean vph = validation.validatePhone(touristForm.getPhone());
        boolean vnf = validation.validateStringField(touristForm.getNegative_features());
        boolean vpd = validation.validateStringField(touristForm.getPhysical_data());


        if (vd && ve && vn && vs && vp && vph && vnf && vpd) {
            LocalDate birth = LocalDate.parse(touristForm.getBirthday(), formatter);
            Tourist newTourist = new Tourist(touristForm.getId(), touristForm.getSurname(), touristForm.getName(),
                    touristForm.getPatronic(), touristForm.getNegative_features(), touristForm.getPhone(),
                    birth, touristForm.getEmail(), category, Boolean.parseBoolean(touristForm.getSex()),
                    LocalDateTime.now(), LocalDateTime.now(),touristForm.getPhysical_data());

            service.save(newTourist);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("tourists", service.getAll());
            return "redirect:/web/tourist/list";
        }else {
            return "wrongData";
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        Tourist tourist = service.get(id);
        Map<String, String> mavs = categoryService.getAll().stream()
                .collect(Collectors.toMap(Category::getId, Category::getCategoryName));


        TouristForm touristForm = new TouristForm();
        touristForm.setId(tourist.getId());
        touristForm.setName(tourist.getName());
        touristForm.setSurname(tourist.getSurname());
        touristForm.setPatronic(tourist.getPatronic());
        touristForm.setNegative_features(tourist.getNegative_features());
        touristForm.setPhone(tourist.getPhone());
        touristForm.setEmail(tourist.getEmail());
        touristForm.setPhysical_data(tourist.getPhysical_data());
        touristForm.setBirthday(tourist.getBirthday().toString());
        touristForm.setSex(tourist.getSex().toString());
        touristForm.setMax_category(tourist.getMax_category().getCategoryName());
        model.addAttribute("touristForm", touristForm);
        model.addAttribute("mavs", mavs);
        return "touristEdit";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                              @ModelAttribute("touristForm") TouristForm touristForm,
                              @PathVariable("id") String id){

        Tourist tourist = new Tourist();


        Validation validation = new Validation();
        boolean vd = validation.validateDate(touristForm.getBirthday());
        boolean ve = validation.validateEmail(touristForm.getEmail());
        boolean vn = validation.validateName(touristForm.getName());
        boolean vs = validation.validateName(touristForm.getSurname());
        boolean vp = validation.validateName(touristForm.getPatronic());
        boolean vph = validation.validatePhone(touristForm.getPhone());
        boolean vnf = validation.validateStringField(touristForm.getNegative_features());
        boolean vpd = validation.validateStringField(touristForm.getPhysical_data());
        if (vd && ve && vn && vs && vp && vph && vnf && vpd) {
            Category category = categoryService.get(touristForm.getMax_category());

            tourist.setId(touristForm.getId());
            tourist.setName(touristForm.getName());
            tourist.setSurname(touristForm.getSurname());
            tourist.setPatronic(touristForm.getPatronic());
            tourist.setNegative_features(touristForm.getNegative_features());
            tourist.setPhysical_data(touristForm.getPhysical_data());
            tourist.setPhone(touristForm.getPhone());
            tourist.setEmail(touristForm.getEmail());
            tourist.setBirthday(LocalDate.parse(touristForm.getBirthday(), formatter));
            tourist.setSex(Boolean.parseBoolean(touristForm.getSex()));
            tourist.setMax_category(category);
            service.save(tourist);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("touristForm", touristForm);
            return "redirect:/web/tourist/list";
        }else {
            return "wrongData";
        }
    }



}

package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.TouristForm;
import edu.lera.cursach.model.Captain;
import edu.lera.cursach.model.Category;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
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
//    String nameRegex= "\\p{Upper}(\\p{Lower}+\\s?)";
//    String emailRegex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//    Pattern emailPattern = Pattern.compile(emailRegex);
//    Pattern namePattern = Pattern.compile(nameRegex);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("tourists", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "touristList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Tourist> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourists", list);
        return "touristList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Tourist> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourists", list);
        return "touristList";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Tourist> list = service.sortByName();
        model.addAttribute("tourists", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "touristList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Tourist> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourists", list);
        return "touristList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("tourists", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/tourist/list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        TouristForm touristForm = new TouristForm();

        Map<String, String> mavs = categoryService.getAll().stream()
                .collect(Collectors.toMap(Category::getId, Category::getCategory_name));

        model.addAttribute("mavs", mavs);
        model.addAttribute("touristForm", touristForm);
        return "touristAdd";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                             @ModelAttribute("touristForm") TouristForm touristForm){

        Category category = categoryService.get(touristForm.getMax_category());

        LocalDate birth = LocalDate.parse(touristForm.getBirthday(), formatter);
        Tourist newTourist = new Tourist(touristForm.getId(), touristForm.getSurname(), touristForm.getName(),
                                        touristForm.getPatronic(), touristForm.getNegative_features(), touristForm.getPhone(),
                                        birth, touristForm.getEmail(), category, Boolean.parseBoolean(touristForm.getSex()),
                                        LocalDateTime.now(), LocalDateTime.now(),touristForm.getPhysical_data());
//        Matcher emailMatcher = emailPattern.matcher(touristForm.getEmail());
//        Matcher nameMatcher = namePattern.matcher(touristForm.getName());
//        if (emailMatcher.matches() && nameMatcher.matches()) {
//            service.save(newTourist);
//        } else {
//           if (!nameMatcher.matches()) {
//               System.out.println("INVALID NAME");
//           }
//           if (!emailMatcher.matches()) {
//                System.out.println("INVALID EMAIL");
//            }
//        }
        service.save(newTourist);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("tourists", service.getAll());
        return "redirect:/web/tourist/list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        Tourist tourist = service.get(id);
        Map<String, String> mavs = categoryService.getAll().stream()
                .collect(Collectors.toMap(Category::getId, Category::getCategory_name));


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
        touristForm.setMax_category(tourist.getMax_category().getCategory_name());
        model.addAttribute("touristForm", touristForm);
        model.addAttribute("mavs", mavs);
        return "touristAdd";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                              @ModelAttribute("touristForm") TouristForm touristForm,
                              @PathVariable("id") String id){

        Tourist tourist = new Tourist();
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
    }



}

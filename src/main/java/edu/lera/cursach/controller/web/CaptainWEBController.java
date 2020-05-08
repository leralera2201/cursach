package edu.lera.cursach.controller.web;


import edu.lera.cursach.form.CaptainForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.model.Captain;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.captain.impls.CaptainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/web/captain")
public class CaptainWEBController {
    @Autowired
    CaptainServiceImpl service;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("captains", service.getAll());
        return "captainList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Captain> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("captains", list);
        return "captainList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Captain> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("captains", list);
        return "captainList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Captain> list = service.sortByName();
        model.addAttribute("captains", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "captainList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Captain> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("captains", list);
        return "captainList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("captains", service.getAll());
        return "captainList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CaptainForm captainForm = new CaptainForm();
        model.addAttribute("captainForm", captainForm);
        return "captainAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("captainForm") CaptainForm captainForm) {
        Captain captain = new Captain();
        captain.setName(captainForm.getName());
        captain.setSurname(captainForm.getSurname());
        captain.setPatronic(captainForm.getPatronic());
        captain.setPhone(captainForm.getPhone());
        captain.setBirthday(LocalDate.parse(captainForm.getBirthday(), formatter));
        captain.setEmail(captainForm.getEmail());
        captain.setSalary(Double.parseDouble(captainForm.getSalary()));
        if (captainForm.getSex().equals("woman")) {
            captain.setSex(false);
        }else{
            captain.setSex(true);
        }
        captain.setStarted_work_year(LocalDate.parse(captainForm.getStarted_work_year(),formatter));
        service.save(captain);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("captains", service.getAll());
        return "redirect:/web/captain/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Captain captain = service.get(id);
        CaptainForm captainForm = new CaptainForm();

        captainForm.setName(captain.getName());
        captainForm.setSurname(captain.getSurname());
        captainForm.setPatronic(captain.getPatronic());
        captainForm.setPhone(captain.getPhone());
        captainForm.setBirthday(captain.getBirthday().toString());
        captainForm.setEmail(captain.getEmail());
        captainForm.setSalary(captain.getSalary().toString());
        if (!captain.getSex()) {
            captainForm.setSex("woman");
        }else{
            captainForm.setSex("man");
        }
        captainForm.setStarted_work_year(captain.getStarted_work_year().toString());

        model.addAttribute("captainForm", captainForm);
        return "captainAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("captainForm") CaptainForm captainForm) {
        Captain captain = new Captain();
        captain.setId(id);
        captain.setName(captainForm.getName());
        captain.setSurname(captainForm.getSurname());
        captain.setPatronic(captainForm.getPatronic());
        captain.setPhone(captainForm.getPhone());
        captain.setBirthday(LocalDate.parse(captainForm.getBirthday(), formatter));
        captain.setEmail(captainForm.getEmail());
        captain.setSalary(Double.parseDouble(captainForm.getSalary()));
        if (captainForm.getSex().equals("woman")) {
            captain.setSex(false);
        }else{
            captain.setSex(true);
        }
        captain.setStarted_work_year(LocalDate.parse(captainForm.getStarted_work_year(),formatter));
        service.save(captain);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("captains", service.getAll());
        return "redirect:/web/captain/list";
    }

}

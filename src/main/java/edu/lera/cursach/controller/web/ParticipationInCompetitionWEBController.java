package edu.lera.cursach.controller.web;

//import edu.lera.cursach.form.ParticipationInCompetitionForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.ParticipationInCompetitionForm;
import edu.lera.cursach.model.*;
import edu.lera.cursach.service.captain.impls.CaptainServiceImpl;
import edu.lera.cursach.service.category.impls.CategoryServiceImpl;
import edu.lera.cursach.service.coach.impls.CoachServiceImpl;
import edu.lera.cursach.service.competition.impls.CompetitionServiceImpl;
import edu.lera.cursach.service.competition.impls.CompetitionServiceImpl;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
import edu.lera.cursach.service.tourist.impls.TouristServiceImpl;
import edu.lera.cursach.service.participationInCompetition.impls.ParticipationInCompetitionServiceImpl;
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
@RequestMapping("/web/tourist-participation-in-competition")
public class ParticipationInCompetitionWEBController {
    @Autowired
    ParticipationInCompetitionServiceImpl service;

    @Autowired
    TouristServiceImpl touristService;
    @Autowired
    CompetitionServiceImpl competitionService;

    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("participationInCompetitions", service.getAll());
        return "participationInCompetitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<ParticipationInCompetition> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInCompetitions", list);
        return "participationInCompetitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<ParticipationInCompetition> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInCompetitions", list);
        return "participationInCompetitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-tourist", method = RequestMethod.GET)
    String sortByTourist(Model model){
        List<ParticipationInCompetition> list = service.sortByTouristName();
        model.addAttribute("participationInCompetitions", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "participationInCompetitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-tourist", method = RequestMethod.POST)
    public String searchSortedByTourist(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<ParticipationInCompetition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInCompetitions", list);
        return "participationInCompetitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-competition", method = RequestMethod.GET)
    String sortByCompetition(Model model){
        List<ParticipationInCompetition> list = service.sortByCompetitionName();
        model.addAttribute("participationInCompetitions", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "participationInCompetitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list-by-competition", method = RequestMethod.POST)
    public String searchSortedByCompetition(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<ParticipationInCompetition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInCompetitions", list);
        return "participationInCompetitionList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("participationInCompetitions", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/participationInCompetition/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        ParticipationInCompetitionForm participationInCompetitionForm = new ParticipationInCompetitionForm();

        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        Map<String, String> mavs2 = competitionService.getAll().stream()
                .collect(Collectors.toMap(Competition::getId, Competition::getCompetition_name));

        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);

        model.addAttribute("participationInCompetitionForm", participationInCompetitionForm);
        return "participationInCompetitionAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("participationInCompetitionForm") ParticipationInCompetitionForm participationInCompetitionForm){

        Tourist tourist = touristService.get(participationInCompetitionForm.getTourist());
        Competition competition = competitionService.get(participationInCompetitionForm.getCompetition());


        ParticipationInCompetition participationInCompetition = new ParticipationInCompetition();
        participationInCompetition.setCompetition(competition);
        participationInCompetition.setTourist(tourist);

        service.save(participationInCompetition);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInCompetitions", service.getAll());
        return "redirect:/web/participationInCompetition/list";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        ParticipationInCompetition participationInCompetition = service.get(id);
        Map<String, String> mavs = touristService.getAll().stream()
                .collect(Collectors.toMap(Tourist::getId, Tourist::getNameandSurname));
        Map<String, String> mavs2 = competitionService.getAll().stream()
                .collect(Collectors.toMap(Competition::getId, Competition::getCompetition_name));
        ParticipationInCompetitionForm participationInCompetitionForm = new ParticipationInCompetitionForm();
        participationInCompetitionForm.setId(participationInCompetition.getId());
        participationInCompetitionForm.setCompetition(participationInCompetition.getCompetition().getCompetition_name());
        participationInCompetitionForm.setTourist(participationInCompetition.getTourist().getName());

        model.addAttribute("participationInCompetitionForm", participationInCompetitionForm);
        model.addAttribute("mavs", mavs);
        model.addAttribute("mavs2", mavs2);
        return "participationInCompetitionAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("touristInParticipationInCompetitionForm") ParticipationInCompetitionForm participationInCompetitionForm,
                       @PathVariable("id") String id){

        ParticipationInCompetition participationInCompetition = new ParticipationInCompetition();
        Tourist tourist = touristService.get(participationInCompetitionForm.getTourist());
        Competition competition = competitionService.get(participationInCompetitionForm.getCompetition());

        participationInCompetition.setId(participationInCompetitionForm.getId());
        participationInCompetition.setCompetition(competition);
        participationInCompetition.setTourist(tourist);

        service.save(participationInCompetition);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("participationInCompetitionForm", participationInCompetitionForm);
        return "redirect:/web/participationInCompetition/list";
    }



}

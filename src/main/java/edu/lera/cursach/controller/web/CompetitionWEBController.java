package edu.lera.cursach.controller.web;

import edu.lera.cursach.form.CompetitionForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.model.Competition;
import edu.lera.cursach.model.Section;
import edu.lera.cursach.model.Tourist;
import edu.lera.cursach.service.competition.impls.CompetitionServiceImpl;
import edu.lera.cursach.service.section.impls.SectionServiceImpl;
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
@RequestMapping("/web/competition")
public class CompetitionWEBController {
    @Autowired
    CompetitionServiceImpl service;

    @Autowired
    SectionServiceImpl sectionService;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d H-m");


    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("competitions", service.getAll());
        return "competitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Competition> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("competitions", list);
        return "competitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Competition> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("competitions", list);
        return "competitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Competition> list = service.sortByDate();
        model.addAttribute("competitions", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "competitionList";
    }
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Competition> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("competitions", list);
        return "competitionList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("competitions", service.getAll());
        return "competitionList";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CompetitionForm competitionForm = new CompetitionForm();
        Map<String, String> mavs = sectionService.getAll().stream()
                .collect(Collectors.toMap(Section::getId, Section::getSection_name
                ));

        model.addAttribute("mavs", mavs);
        model.addAttribute("competitionForm", competitionForm);
        return "competitionAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("competitionForm") CompetitionForm competitionForm) {
        Competition competition = new Competition();
        Section section = sectionService.get(competitionForm.getSection());
        competition.setCompetition_name(competitionForm.getCompetition_name());
        competition.setCompetition_date(LocalDateTime.parse(competitionForm.getCompetition_date(), formatter));
        competition.setDescription(competitionForm.getDescription());
        competition.setSection(section);
        service.save(competition);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("competitions", service.getAll());
        return "redirect:/web/competition/list";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Competition competition = service.get(id);
        Map<String, String> mavs = sectionService.getAll().stream()
                .collect(Collectors.toMap(Section::getId, Section::getSection_name
                ));

        model.addAttribute("mavs", mavs);
        CompetitionForm competitionForm = new CompetitionForm();
        competitionForm.setCompetition_name(competition.getCompetition_name());
        competitionForm.setCompetition_date(competition.getCompetition_date().toString());
        competitionForm.setDescription(competition.getDescription());
        competitionForm.setSection(competition.getSection().getSection_name());
        model.addAttribute("competitionForm", competitionForm);
        return "competitionAdd";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("competitionForm") CompetitionForm competitionForm) {
        Competition competition = new Competition();
        competition.setId(id);
        Section section = sectionService.get(competitionForm.getSection());
        competition.setCompetition_name(competitionForm.getCompetition_name());
        competition.setCompetition_date(LocalDateTime.parse(competitionForm.getCompetition_date(), formatter));
        competition.setDescription(competitionForm.getDescription());
        competition.setSection(section);
        service.save(competition);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("competitions", service.getAll());
        return "redirect:/web/competition/list";
    }

}

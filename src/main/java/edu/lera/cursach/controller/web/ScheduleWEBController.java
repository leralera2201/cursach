package edu.lera.cursach.controller.web;

//import edu.lera.cursach.form.ScheduleForm;
import edu.lera.cursach.form.SearchForm;
import edu.lera.cursach.form.ScheduleForm;
import edu.lera.cursach.model.*;
import edu.lera.cursach.service.group.impls.GroupServiceImpl;
import edu.lera.cursach.service.schedule.impls.ScheduleServiceImpl;
import edu.lera.cursach.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/schedule")
public class ScheduleWEBController {
    @Autowired
    ScheduleServiceImpl service;

    @Autowired
    GroupServiceImpl groupService;

    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d H-m");
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("schedules", service.getAll());
        return "scheduleList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Schedule> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("schedules", list);
        return "scheduleList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String name = searchForm.getName();
        List<Schedule> list = service.search(name);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("schedules", list);
        return "scheduleList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.GET)
    String sort(Model model){
        List<Schedule> list = service.sortByDate();
        model.addAttribute("schedules", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "scheduleList";
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping(value = "/sorted-list", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getName();
        List<Schedule> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("schedules", list);
        return "scheduleList";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("schedules", service.getAll());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "redirect:/web/schedule/list";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model){
        ScheduleForm scheduleForm = new ScheduleForm();

        Map<String, String> mavs = groupService.getAll().stream()
                .collect(Collectors.toMap(Group::getId, Group::getGroup_name));


        model.addAttribute("mavs", mavs);

        model.addAttribute("scheduleForm", scheduleForm);
        return "scheduleAdd";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,
                         @ModelAttribute("scheduleForm") ScheduleForm scheduleForm){

        Group group = groupService.get(scheduleForm.getGroup());


        Schedule schedule = new Schedule();
        Validation validation = new Validation();
        boolean vn = validation.validateName(scheduleForm.getTrain_name());
        boolean vd = validation.validateStringField(scheduleForm.getDescription());
        boolean vp = validation.validateStringField(scheduleForm.getPlace());
        boolean vpm = validation.validateDouble(scheduleForm.getPayment());
        boolean vt = validation.validateDouble(scheduleForm.getTime());
        boolean vdt = validation.validateDateTime(scheduleForm.getStarted_datetime());
        if (vn && vd && vdt && vp && vpm && vt) {
            schedule.setTrain_name(scheduleForm.getTrain_name());
            schedule.setDescription(scheduleForm.getDescription());
            schedule.setPayment(Double.parseDouble(scheduleForm.getPayment()));
            schedule.setTime(Double.parseDouble(scheduleForm.getTime()));
            schedule.setStarted_datetime(LocalDateTime.parse(scheduleForm.getStarted_datetime(), formatter));
            schedule.setPlace(scheduleForm.getPlace());
            schedule.setGroup(group);

            service.save(schedule);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("schedules", service.getAll());
            return "redirect:/web/schedule/list";
        }else {
            return "wrongData";
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable("id") String id){

        Schedule schedule = service.get(id);
        Map<String, String> mavs = groupService.getAll().stream()
                .collect(Collectors.toMap(Group::getId, Group::getGroup_name));

        ScheduleForm scheduleForm = new ScheduleForm();
        scheduleForm.setId(schedule.getId());
        scheduleForm.setTrain_name(schedule.getTrain_name());
        scheduleForm.setDescription(schedule.getDescription());
        scheduleForm.setPayment(schedule.getPayment().toString());
        scheduleForm.setTime(schedule.getTime().toString());
        scheduleForm.setStarted_datetime(schedule.getStarted_datetime().toString());
        scheduleForm.setPlace(schedule.getPlace());
        scheduleForm.setGroup(schedule.getGroup().getGroup_name());

        model.addAttribute("scheduleForm", scheduleForm);
        model.addAttribute("mavs", mavs);

        return "scheduleEdit";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("scheduleForm") ScheduleForm scheduleForm,
                       @PathVariable("id") String id){

        Schedule schedule = new Schedule();
        Group group = groupService.get(scheduleForm.getGroup());

        Validation validation = new Validation();
        boolean vn = validation.validateName(scheduleForm.getTrain_name());
        boolean vd = validation.validateStringField(scheduleForm.getDescription());
        boolean vp = validation.validateStringField(scheduleForm.getPlace());
        boolean vpm = validation.validateDouble(scheduleForm.getPayment());
        boolean vt = validation.validateDouble(scheduleForm.getTime());
        boolean vdt = validation.validateDateTime(scheduleForm.getStarted_datetime());
        if (vn && vd && vdt && vp && vpm && vt) {
            schedule.setId(scheduleForm.getId());
            schedule.setTrain_name(scheduleForm.getTrain_name());
            schedule.setDescription(scheduleForm.getDescription());
            schedule.setPayment(Double.parseDouble(scheduleForm.getPayment()));
            schedule.setTime(Double.parseDouble(scheduleForm.getTime()));
            schedule.setStarted_datetime(LocalDateTime.parse(scheduleForm.getStarted_datetime(), formatter));
            schedule.setPlace(scheduleForm.getPlace());
            schedule.setGroup(group);

            service.save(schedule);
            SearchForm searchForm = new SearchForm();
            model.addAttribute("searchForm", searchForm);
            model.addAttribute("scheduleForm", scheduleForm);
            return "redirect:/web/schedule/list";
        }else {
            return "wrongData";
        }


    }



}

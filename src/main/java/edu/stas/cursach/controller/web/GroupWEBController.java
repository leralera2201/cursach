package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Group;
import edu.stas.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/web/group")
public class GroupWEBController {
    @Autowired
    GroupServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("groups", service.getAll());
        return "groupList";
    }

}

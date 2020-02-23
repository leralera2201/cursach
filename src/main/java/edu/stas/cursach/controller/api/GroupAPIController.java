package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.Group;
import edu.stas.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupAPIController {
    @Autowired
    GroupServiceImpl service;

    @RequestMapping("/list")
    List<Group> getAll() {
        return service.getAll();
    }

}
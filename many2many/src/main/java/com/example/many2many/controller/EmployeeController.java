package com.example.many2many.controller;

import com.example.many2many.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService service;

    @GetMapping("/getManyToManyInsert")
    public String getManyToManyInsert(Model model) throws Exception {
        log.info("getManyToManyInsert()");

        service.getManyToManyInsert();

        return "employee/success.html";
    }

    @GetMapping("/getManyToManyFind")
    public String getManyToManyFind(Model model) throws Exception {
        log.info("getManyToManyFind()");

        service.getManyToManyFind();

        return "employee/success.html";
    }
}

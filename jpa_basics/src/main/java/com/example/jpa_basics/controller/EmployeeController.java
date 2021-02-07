package com.example.jpa_basics.controller;

import com.example.jpa_basics.entity.Employee;
import com.example.jpa_basics.service.EmployeeService;
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

    @GetMapping("/getRegister")
    public String getRegister(Employee emp, Model model) throws Exception {
        log.info("getRegister()");

        service.registerTest();

        return "employee/success.html";
    }
}

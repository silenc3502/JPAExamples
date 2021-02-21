package com.example.one2one.controller;

import com.example.one2one.entity.Employee;
import com.example.one2one.service.EmployeeService;
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

    @GetMapping("/GetEmpCard")
    public String GetEmpCard(Employee emp, Model model) throws Exception {
        log.info("GetEmpCard()");

        service.GetEmpCard();

        return "employee/success.html";
    }
}

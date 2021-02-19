package com.example.many2one.controller;

import com.example.many2one.entity.Employee;
import com.example.many2one.service.EmployeeService;
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

    @GetMapping("/getList")
    public String getList(Employee emp, Model model) throws Exception {
        log.info("getList()");

        service.getListTest();

        return "employee/success.html";
    }
}

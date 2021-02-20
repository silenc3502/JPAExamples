package com.example.many2one_delete.controller;

import com.example.many2one_delete.entity.Employee;
import com.example.many2one_delete.service.EmployeeService;
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

    @GetMapping("/getInsert")
    public String getInsert(Employee emp, Model model) throws Exception {
        log.info("getInsert()");

        service.getInsertTest();

        return "employee/success.html";
    }

    @GetMapping("/getFind")
    public String getFind(Employee emp, Model model) throws Exception {
        log.info("getFind()");

        service.getFindTest(2L);

        return "employee/success.html";
    }

    @GetMapping("/getUpdate")
    public String getUpdate(Employee emp, Model model) throws Exception {
        log.info("getUpdate()");

        service.getUpdateTest();

        return "employee/success.html";
    }

    @GetMapping("/getDelete")
    public String getDelete(Employee emp, Model model) throws Exception {
        log.info("getDelete()");

        service.getDeleteTest();

        return "employee/success.html";
    }
}

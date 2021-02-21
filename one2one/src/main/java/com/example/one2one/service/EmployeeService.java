package com.example.one2one.service;

import com.example.one2one.entity.Employee;
import com.example.one2one.entity.EmployeeCard;
import com.example.one2one.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public void getFindTest(Long num) {
        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.findInfo(num);
    }

    public void GetEmpCard() throws ParseException {
        Employee emp = new Employee();
        emp.setName("강화학습");

        EmployeeCard card = new EmployeeCard();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        card.setExpireDate(sdf.parse("2025-12-31"));
        card.setRole("MASTER");
        card.setEmployee(emp);

        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.GetEmpCard(emp, card);
    }
}

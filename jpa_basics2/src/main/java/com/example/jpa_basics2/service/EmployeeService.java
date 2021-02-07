package com.example.jpa_basics2.service;

import com.example.jpa_basics2.entity.Employee;
import com.example.jpa_basics2.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeService {

    public void registerTest() {
        Employee emp = new Employee();

        emp.setName("Golang");
        emp.setStartDate(new Timestamp(System.currentTimeMillis()));
        emp.setTitle("NG Language");
        emp.setDeptName("High Performance");
        emp.setSalary(4400.0);

        EmployeeRepository empRepository = new EmployeeRepository();
        empRepository.insertEmployee(emp);

        List<Employee> employeeList = empRepository.getEmployeeList();

        for(Employee tmp: employeeList) {
            System.out.println("res: " + tmp.toString());
        }
    }

    public void findInfo(Long num) {
        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.findInfo(num);
    }
}

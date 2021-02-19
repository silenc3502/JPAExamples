package com.example.jpa_basics3.service;

import com.example.jpa_basics3.entity.Employee;
import com.example.jpa_basics3.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeService {

    public void registerTest() {

        Employee[] emp = new Employee[100];

        for(int i = 0; i < 100; i++) {
            emp[i] = new Employee();

            emp[i].setName("Person" + (i + 1));
            emp[i].setStartDate(new Timestamp(System.currentTimeMillis()));
            emp[i].setTitle("NG Language");
            emp[i].setDeptName("High Performance");
            emp[i].setSalary(4400.0);
        }

        EmployeeRepository empRepository = new EmployeeRepository();
        empRepository.insertEmployeeArr(emp);

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

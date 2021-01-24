package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}

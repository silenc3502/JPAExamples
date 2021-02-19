package com.example.many2one.service;

import com.example.many2one.entity.Employee;
import com.example.many2one.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeService {

    public void getListTest() {
        EmployeeRepository empRepository = new EmployeeRepository();
        List<Employee> employeeList = empRepository.getEmployeeList();

        for(Employee tmp: employeeList) {
            System.out.println("res: " + tmp.getName() + "의 부서명 : " + tmp.getDept().getName());
        }
    }
}

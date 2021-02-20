package com.example.many2one2.service;

import com.example.many2one2.entity.Department;
import com.example.many2one2.entity.Employee;
import com.example.many2one2.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    public void getInsertTest() {
        Department depart = new Department();
        depart.setName("소프트웨어 개발");

        List<Employee> empList = new ArrayList<Employee>();

        for(int i = 1; i <= 2; i++) {
            Employee emp = new Employee();
            emp.setName("펌웨어");
            emp.setDept(depart);
            empList.add(emp);
        }

        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.insertEmployee(empList, depart);

        for(Employee tmp: empList) {
            System.out.println("res: " + tmp.getName() + "의 부서명 : " + tmp.getDept().getName());
        }
    }

    public void getFindTest(Long num) {
        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.findInfo(num);
    }
}

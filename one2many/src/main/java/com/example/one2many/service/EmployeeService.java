package com.example.one2many.service;

import com.example.one2many.entity.Department;
import com.example.one2many.entity.Employee;
import com.example.one2many.repository.EmployeeRepository;
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

    public void getUpdateTest() {
        Department depart = new Department();
        depart.setName("인증팀");

        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.updateEmployee(depart, 1L);
    }

    public void getDeleteTest() {
        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.deleteDepart(2L, 1L);
    }

    public void getFindTest(Long num) {
        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.findInfo(num);
    }

    public void getMany2OneBothWay() {
        EmployeeRepository empRepo = new EmployeeRepository();
        empRepo.findMany2OneBothWay(2L);
    }
}

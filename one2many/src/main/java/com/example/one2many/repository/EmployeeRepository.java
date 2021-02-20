package com.example.one2many.repository;

import com.example.one2many.entity.Department;
import com.example.one2many.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    public EmployeeRepository() {
        emf = Persistence.createEntityManagerFactory("one2many");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    public void insertEmployee(List<Employee> empList, Department depart) {
        System.out.println("JPA Based Registration");

        // System.out.println(entity);

        try {
            et.begin();
            em.persist(depart);

            for(int i = 0; i < empList.size(); i++) {
                em.persist(empList.get(i));
            }

            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    public void findInfo(Long num) {
        System.out.println("JPA Based Search");

        try {
            Employee findEmp = em.find(Employee.class, num);
            System.out.println(findEmp.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Department depart, Long num) {
        System.out.println("JPA Based Update");

        // System.out.println(entity);
        Employee emp;

        try {
            et.begin();
            em.persist(depart);

            emp = em.find(Employee.class, num);
            emp.setDept(depart);

            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    public void deleteDepart(Long empNum, Long departNum) {
        System.out.println("JPA Based Delete");

        // System.out.println(entity);
        Employee emp;

        try {
            et.begin();

            emp = em.find(Employee.class, empNum);
            emp.setDept(null);

            Department depart = em.find(Department.class, departNum);
            em.remove(depart);

            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    public void findMany2OneBothWay(Long departNum) {
        System.out.println("JPA Based One2Many");

        Department depart;

        depart = em.find(Department.class, departNum);

        System.out.println("검색된 부서: " + depart.getName());
        System.out.println("부서에 소속된 직원 명단:");

        for(Employee emp : depart.getEmployeeList()) {
            System.out.println(emp.getName() + "(" + emp.getDept().getName() + ")");
        }
    }
}

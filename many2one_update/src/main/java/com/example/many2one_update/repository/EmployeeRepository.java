package com.example.many2one_update.repository;

import com.example.many2one_update.entity.Department;
import com.example.many2one_update.entity.Employee;

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
        emf = Persistence.createEntityManagerFactory("many2one_update");
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
}

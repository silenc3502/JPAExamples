package com.example.jpa_basics3.repository;

import com.example.jpa_basics3.entity.Employee;

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
        emf = Persistence.createEntityManagerFactory("jpa_basics3");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    public void insertEmployee(Employee entity) {
        System.out.println("JPA Based Registration");

        // System.out.println(entity);

        try {
            et.begin();
            em.persist(entity);
            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    public void insertEmployeeArr(Employee[] entity) {
        System.out.println("JPA Based Arr Registration");

        // System.out.println(entity);

        try {
            et.begin();

            for(int i = 0; i < entity.length; i++) {
                em.persist(entity[i]);
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

    public List<Employee> getEmployeeList() {
        System.out.println("Hibernate Based Listing");

        String jpql = "select e from Employee e order by e.id";
        List<Employee> employeeList = em.createQuery(jpql).getResultList();

        return employeeList;
    }
}

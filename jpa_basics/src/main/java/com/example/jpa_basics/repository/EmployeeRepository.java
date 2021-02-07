package com.example.jpa_basics.repository;

import com.example.jpa_basics.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.List;

public class EmployeeRepository {
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    public EmployeeRepository() {
        emf = Persistence.createEntityManagerFactory("jpa_basics");
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

    public List<Employee> getEmployeeList() {
        System.out.println("Hibernate Based Listing");

        String jpql = "select e from Employee e order by e.id";
        List<Employee> employeeList = em.createQuery(jpql).getResultList();

        return employeeList;
    }
}

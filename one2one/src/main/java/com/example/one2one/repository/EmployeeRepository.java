package com.example.one2one.repository;

import com.example.one2one.entity.Employee;
import com.example.one2one.entity.EmployeeCard;

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
        emf = Persistence.createEntityManagerFactory("one2one");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    public void GetEmpCard(Employee emp, EmployeeCard card) {
        System.out.println("JPA Based Registration");

        try {
            et.begin();

            em.persist(emp);
            em.persist(card);

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
}

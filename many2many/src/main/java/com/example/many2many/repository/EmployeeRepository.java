package com.example.many2many.repository;

import com.example.many2many.entity.Order;
import com.example.many2many.entity.Product;

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
        emf = Persistence.createEntityManagerFactory("many2many");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    public void getManyToManyInsert(List<Product> productList, Order order) {
        System.out.println("JPA Based Registration");

        try {
            et.begin();

            for(int i = 0; i < 2; i++) {
                em.persist(productList.get(i));
            }

            em.persist(order);

            et.commit();
        } catch (Exception e) {
            et.rollback();
        }
    }

    public void getManyToManyFind(Long num) {
        System.out.println("JPA Based Search");

        try {
            Order order = em.find(Order.class, num);
            System.out.println(order.getId() + "번 주문에 대한 상품 목록");

            List<Product> productList = order.getProductList();

            for(Product product : productList) {
                System.out.println("---> " + product.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

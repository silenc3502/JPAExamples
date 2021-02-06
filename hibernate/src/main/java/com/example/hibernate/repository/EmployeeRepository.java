package com.example.hibernate.repository;

import com.example.hibernate.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.List;

public class EmployeeRepository {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    private SqlSession mybatis;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public EmployeeRepository() {
        String config = "hibernate/hibernate.cfg.xml";

        sessionFactory = new Configuration().configure(config).buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.getTransaction();
    }

    public void insertEmployee(Employee entity) {
        System.out.println("Hibernate Based Registration");

        // System.out.println(entity);

        try {
            transaction.begin();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }

    public List<Employee> getEmployeeList() {
        System.out.println("Hibernate Based Listing");

        String jpql = "select e from Employee e order by e.id";
        List<Employee> employeeList = session.createQuery(jpql).getResultList();

        return employeeList;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jpa_test?serverTimezone=UTC&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, "bitweb", "dkdlxl123");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs = null;
        }

        try {
            if(stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }

        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }

    public void close(Statement stmt, Connection conn) {
        try {
            if(stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stmt = null;
        }

        try {
            if(conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn = null;
        }
    }
}

package com.example.mybatis.repository;

import com.example.mybatis.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private SqlSession mybatis;

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public EmployeeRepository() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            mybatis = sessionFactory.openSession();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void insertEmployee(Employee entity) {
        System.out.println("MyBatis Based Registration");

        mybatis.insert("EmployeeRepository.insertEmployee", entity);
        mybatis.commit();
    }

    public List<Employee> getEmployeeList() {
        System.out.println("MyBatis Based Listing");

        return mybatis.selectList("EmployeeRepository.getEmployeeList");
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

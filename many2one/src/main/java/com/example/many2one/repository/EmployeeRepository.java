package com.example.many2one.repository;

import com.example.many2one.entity.Department;
import com.example.many2one.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<Employee>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select e.id, e.name, " +
                    "d.dept_id, d.name dname from s_emp e, s_dept d " +
                    "where e.dept_id = d.dept_id order by id asc");
            rs = stmt.executeQuery();

            while(rs.next()) {
                Employee emp = new Employee();

                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));

                Department depart = new Department();

                depart.setDeptId(rs.getLong("dept_id"));
                depart.setName(rs.getString("dname"));

                emp.setDept(depart);
                employeeList.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(rs, stmt, conn);
        }

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

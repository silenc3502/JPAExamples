package com.example.demo.repository;

import com.example.demo.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private String INSERT_EMP =
            "insert into s_emp(name, start_date, title, dept_name, salary) " +
                    "values(?, ?, ?, ?, ?)";

    private String LIST_EMP =
            "select id, name, start_date, title, dept_name, salary " +
                    "from s_emp order by name";

    public void insertEmployee(Employee entity) {
        System.out.println("JDBC Based Registration");

        try {
            conn = getConnection();

            System.out.println("Connection Success!");

            stmt = conn.prepareStatement(INSERT_EMP);
            stmt.setString(1, entity.getName());
            stmt.setTimestamp(2, entity.getStartDate());
            stmt.setString(3, entity.getTitle());
            stmt.setString(4, entity.getDeptName());
            stmt.setDouble(5, entity.getSalary());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(stmt, conn);
        }
    }

    public List<Employee> getEmployeeList() {
        System.out.println("JDBC Based List");

        List<Employee> employeeList = new ArrayList<Employee>();

        try {
            conn = getConnection();

            stmt = conn.prepareStatement(LIST_EMP);
            rs = stmt.executeQuery();

            while(rs.next()) {
                Employee emp = new Employee();

                emp.setId(rs.getLong("id"));
                emp.setName(rs.getString("name"));
                emp.setStartDate(rs.getTimestamp("start_date"));
                emp.setTitle(rs.getString("title"));
                emp.setDeptName(rs.getString("dept_name"));
                emp.setSalary(rs.getDouble("salary"));

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

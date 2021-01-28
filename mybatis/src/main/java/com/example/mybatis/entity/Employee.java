package com.example.mybatis.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Employee {
    private Long id;
    private String name;
    private Timestamp startDate;
    private String title;
    private String deptName;
    private Double salary;
}

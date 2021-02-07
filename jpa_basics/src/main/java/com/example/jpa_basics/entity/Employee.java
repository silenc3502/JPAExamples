package com.example.jpa_basics.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="s_emp")
public class Employee {
    @Id
    @GeneratedValue(generator="increment")
    private Long id;
    private String name;

    @Column(name="start_date")
    private Timestamp startDate;
    private String title;

    @Column(name="dept_name")
    private String deptName;
    private Double salary;
}

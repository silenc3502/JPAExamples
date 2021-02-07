package com.example.jpa_basics2.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@ToString(exclude = {"isMVP"})
@Entity
@Table(name="s_emp")
public class Employee {
    @Id
    //@GeneratedValue(generator="increment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @Column(name="start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private String title;

    @Column(name="dept_name")
    private String deptName;

    @Column(precision = 10, scale = 3)
    private Double salary;

    @Transient
    private Boolean isMVP;
}

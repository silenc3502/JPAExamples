package com.example.jpa_basics3.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@ToString(exclude = {"isMVP"})
@Entity
@Table(name="s_emp")
@SequenceGenerator(name = "s_emp_generator",
                    sequenceName = "s_emp_sequence",
                    initialValue = 1,
                    allocationSize = 50)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "s_emp_generator")
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

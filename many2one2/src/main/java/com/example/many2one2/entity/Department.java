package com.example.many2one2.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "s_dept")
public class Department {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "dept_id")
    private Long deptId;

    @Column(length = 25, nullable = false)
    private String name;
}

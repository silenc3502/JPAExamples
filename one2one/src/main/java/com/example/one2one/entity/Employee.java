package com.example.one2one.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "s_emp")
public class Employee {
    @Id
    @GeneratedValue(generator = "increment")
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;
}

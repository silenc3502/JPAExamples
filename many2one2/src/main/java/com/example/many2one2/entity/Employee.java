package com.example.many2one2.entity;

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

    // Many2One은 Many에 해당하는 Entity가
    // One에 해당하는 Entity를 참조할 때 Many에 해당하는 Entity에 설정한다.
    // @ManyToOne(targetEntity = com.example.many2one2.entity.Department.class)
    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department dept;
}

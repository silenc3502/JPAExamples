package com.example.one2many_cascade.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
// 일대다 맵핑에서 중복 저장이 크게 문제 되지 않는다면 List 를 사용해도 무방하다.
//@EqualsAndHashCode(exclude = "employeeList")
@Table(name = "s_dept")
public class Department {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "dept_id")
    private Long deptId;

    @Column(length = 25, nullable = false)
    private String name;

    @OneToMany(mappedBy = "dept", cascade = CascadeType.PERSIST)
    private List<Employee> employeeList = new ArrayList<Employee>();
    //private Set<Employee> employeeList = new HashSet<Employee>();
}

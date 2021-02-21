package com.example.one2one.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "s_emp_card")
public class EmployeeCard {
    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "card_id")
    private Long cardId;

    @Column(name = "expire_date")
    private Date expireDate;

    private String role;

    @OneToOne
    @JoinColumn(name = "emp_card_id")
    private Employee employee;

    // @ManyToOne
    // @JoinColumn(name = "emp_card_id")
    // private List<Employee> employeeList;
}

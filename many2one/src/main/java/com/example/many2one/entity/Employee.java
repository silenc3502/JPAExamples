package com.example.many2one.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
public class Employee {
    private Long id;
    private String name;
    private Department dept;
}

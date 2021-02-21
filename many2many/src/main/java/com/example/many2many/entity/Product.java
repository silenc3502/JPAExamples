package com.example.many2many.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "s_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    private String category;
}

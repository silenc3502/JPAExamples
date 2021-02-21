package com.example.many2many.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "s_ord")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "order_date")
    private Date orderDate;

    private Double total;

    @ManyToMany
    @JoinTable(name = "s_item",
        joinColumns = @JoinColumn(name = "ord_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"ord_id", "product_id"})
    )
    private List<Product> productList = new ArrayList<Product>();
}

package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
public class Orders {
    @Id
    private String id;
    @Column(name = "orderdate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;
    @Column(name = "totalamount")
    private Integer totalAmount;
    @Column(name = "status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetails;
}

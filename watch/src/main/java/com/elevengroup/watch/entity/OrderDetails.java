package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "orderdetails")
public class OrderDetails {
    @Id
    private String id;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "unitprice")
    private Integer unitPrice;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;
}

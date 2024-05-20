package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cartitems")
public class CartItems {
    @Id
    private String id;
    @Column(name = "quantity")
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;
}

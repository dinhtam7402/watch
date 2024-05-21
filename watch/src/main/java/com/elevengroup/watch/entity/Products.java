package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Products {
    @Id
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "sex")
    private String sex;
    @Column(name = "cost")
    private Integer cost;
    @Column(name = "price")
    private Integer price;
    @Column(name = "sold")
    private Integer sold;
    @Column(name = "stockquantity")
    private Integer stockQuantity;
    @Column(name = "imgurl")
    private String imgUrl;
    @Column(name = "description")
    private String description;

    @Column(name = "dialcolor")
    private String dialColor;
    @Column(name = "casematerial")
    private String caseMaterial;
    @Column(name = "strapmaterial")
    private String strapMaterial;
    @Column(name = "movementtype")
    private String movementType;
    @Column(name = "waterresistance")
    private Integer waterResistance;
    @Column(name = "casediameter")
    private Integer caseDiameter;
    @Column(name = "casethickness")
    private Integer caseThickness;
    @Column(name = "powerreserve")
    private Integer powerReserve;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<OrderDetails> orderDetails;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reviews> reviews;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItems> cartItems;
}

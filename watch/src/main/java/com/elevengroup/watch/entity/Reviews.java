package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Table(name = "reviews")
public class Reviews {
    @Id
    private String id;

    @Column(name = "rating")
    private Integer rating;
    @Column(name = "comment")
    private String comment;
    @Column(name = "createdat")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}

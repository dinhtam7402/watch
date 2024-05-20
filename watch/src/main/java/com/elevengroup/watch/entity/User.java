package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    private String id;

    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    @OneToOne(mappedBy = "user")
    private Customer customer;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reviews> reviews;

    @PrePersist
    protected void onCreate() {
        if (this.role == null) {
            this.role = "USER";
        }
    }
}

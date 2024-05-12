package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makhachhang")
    private Long maKhachHang;
    @Column(name = "hoten")
    private String hoTen;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "email")
    private String email;
    @Column(name = "diachi")
    private String diaChi;
}

package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Data
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machitiet")
    private Long maChiTiet;
    @ManyToOne
    @JoinColumn(name = "mahoadon")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "masanpham")
    private SanPham sanPham;
    @Column(name = "soluong")
    private int soLuong;
    @Column(name = "dongia")
    private String donGia;
    @Column(name = "thanhtien")
    private String thanhTien;
}

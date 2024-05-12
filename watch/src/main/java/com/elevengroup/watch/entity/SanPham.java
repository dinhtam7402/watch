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
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "masanpham")
    private Long maSanPham;
    @ManyToOne
    @JoinColumn(name = "mathuonghieu")
    private ThuongHieu thuongHieu;
    @Column(name = "tensanpham")
    private String tenSanPham;
    @Column(name = "gia")
    private String gia;
    @Column(name = "gioitinh")
    private String gioiTinh;
    @Column(name = "chatlieuday")
    private String chatLieuDay;
    @Column(name = "chatlieumatkinh")
    private String chatLieuMatKinh;
    @Column(name = "pin")
    private String pin;
    @Column(name = "maumatso")
    private String mauMatSo;
    @Column(name = "mauvo")
    private String mauVo;
    @Column(name = "hinhdangmatso")
    private String hinhDangMatSo;
    @Column(name = "kichthuoc")
    private String kichThuoc;
    @Column(name = "mucchongnuoc")
    private String mucChongNuoc;
    @Column(name = "bosuutap")
    private String boSuuTap;
}

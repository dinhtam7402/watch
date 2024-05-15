package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Data
@Table(name = "thuonghieu")
public class ThuongHieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mathuonghieu")
    private Long maThuongHieu;
    @Column(name = "tenthuonghieu")
    private String tenThuongHieu;
    @Column(name = "sodienthoai")
    private String soDienThoai;
    @Column(name = "diachi")
    private String diaChi;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy = "thuongHieu", cascade = CascadeType.ALL)
    private List<SanPham> sanPham;
}

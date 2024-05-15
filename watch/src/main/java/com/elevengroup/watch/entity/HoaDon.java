package com.elevengroup.watch.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Table(name = "hoadon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahoadon")
    private Long maHoaDon;
    @ManyToOne
    @JoinColumn(name = "makhachhang")
    private KhachHang khachHang;
    @Column(name = "ngaydat")
    private LocalDate ngayDat;
    @Column(name = "diachigiaohang")
    private String diaChiGiaoHang;
    @Column(name = "tongtien")
    private String tongTien;
    @Column(name = "phuongthucthanhtoan")
    private String phuongThucThanhToan;
    @Column(name = "trangthai")
    private String trangThai;
    @OneToMany(mappedBy = "hoaDon", cascade = CascadeType.ALL)
    private List<ChiTietHoaDon> chiTietHoaDon;
}

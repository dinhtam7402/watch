package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailInvoiceRepository extends JpaRepository<ChiTietHoaDon, Long> {
    @Query("SELECT hd FROM ChiTietHoaDon hd WHERE hd.hoaDon.maHoaDon = :maHoaDon")
    List<ChiTietHoaDon> findAllByInvoiceId(Long maHoaDon);
}

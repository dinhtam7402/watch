package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<SanPham, Long> {
    Page<SanPham> findAll(Pageable pageable);
    @Query("SELECT sp FROM SanPham sp WHERE sp.thuongHieu.maThuongHieu = :mathuonghieu")
    List<SanPham> findAllByBrandId(long mathuonghieu);
}

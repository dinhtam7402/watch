package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<SanPham, Long> {
    Page<SanPham> findAll(Pageable pageable);
}

package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<KhachHang, Integer> {
    Page<KhachHang> findAll(Pageable pageable);
}

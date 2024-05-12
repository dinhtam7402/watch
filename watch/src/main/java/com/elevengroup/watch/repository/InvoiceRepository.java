package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<HoaDon, Long> {
    Page<HoaDon> findAll(Pageable pageable);
}

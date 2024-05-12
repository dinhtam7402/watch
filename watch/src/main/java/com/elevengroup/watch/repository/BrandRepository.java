package com.elevengroup.watch.repository;

import com.elevengroup.watch.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<ThuongHieu, Long> {
    Page<ThuongHieu> findAll(Pageable pageable);
}

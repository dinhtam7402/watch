package com.elevengroup.watch.service;

import com.elevengroup.watch.entity.ThuongHieu;

import java.util.Optional;

public interface BrandService {
    Optional<ThuongHieu> getById(Long id);
    ThuongHieu saveBrand(ThuongHieu thuongHieu);
    void deleteById(Long id);
}

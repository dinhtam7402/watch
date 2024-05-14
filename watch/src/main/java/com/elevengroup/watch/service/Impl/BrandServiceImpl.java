package com.elevengroup.watch.service.Impl;

import com.elevengroup.watch.entity.SanPham;
import com.elevengroup.watch.entity.ThuongHieu;
import com.elevengroup.watch.repository.BrandRepository;
import com.elevengroup.watch.repository.ProductRepository;
import com.elevengroup.watch.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ThuongHieu> getById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public ThuongHieu saveBrand(ThuongHieu thuongHieu) {
        return brandRepository.save(thuongHieu);
    }

    @Override
    public void deleteById(Long id) {
        List<SanPham> products = productRepository.findAllByBrandId(id);

        for (SanPham product : products) {
            product.setThuongHieu(null);
            productRepository.save(product);
        }
        brandRepository.deleteById(id);
    }
}

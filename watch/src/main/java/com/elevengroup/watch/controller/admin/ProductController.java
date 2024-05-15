package com.elevengroup.watch.controller.admin;

import com.elevengroup.watch.entity.SanPham;
import com.elevengroup.watch.entity.ThuongHieu;
import com.elevengroup.watch.repository.BrandRepository;
import com.elevengroup.watch.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewProduct(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size, Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<SanPham> pageTuts = productRepository.findAll(pageable);

        model.addAttribute("products", pageTuts.getContent());
        model.addAttribute("currentPage", pageTuts.getNumber() + 1);
        model.addAttribute("totalPages", pageTuts.getTotalPages());
        model.addAttribute("pageSize", size);

        return "admin/product/product";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String viewCreate(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("product", new SanPham());
        return "admin/product/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProductNew(@ModelAttribute("product") SanPham sanPham) {
        productRepository.save(sanPham);
        return "redirect:/admin/product/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        model.addAttribute("product", productRepository.findById(id).orElse(null));
        return "admin/product/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateBrand(@PathVariable("id") Long id, @Valid SanPham sanPham, BindingResult result) {
        if (result.hasErrors()) {
            sanPham.setMaSanPham(id);
            return "admin/product/update";
        } else {
            Optional<SanPham> existingSanPhamOptional = productRepository.findById(id);

            if (existingSanPhamOptional.isPresent()) {
                SanPham updateProduct = existingSanPhamOptional.get();

                updateProduct.setThuongHieu(sanPham.getThuongHieu());
                updateProduct.setTenSanPham(sanPham.getTenSanPham());
                updateProduct.setGia(sanPham.getGia());
                updateProduct.setGioiTinh(sanPham.getGioiTinh());
                updateProduct.setChatLieuDay(sanPham.getChatLieuDay());
                updateProduct.setChatLieuMatKinh(sanPham.getChatLieuMatKinh());
                updateProduct.setPin(sanPham.getPin());
                updateProduct.setMauMatSo(sanPham.getMauMatSo());
                updateProduct.setMauVo(sanPham.getMauVo());
                updateProduct.setHinhDangMatSo(sanPham.getHinhDangMatSo());
                updateProduct.setKichThuoc(sanPham.getKichThuoc());
                updateProduct.setMucChongNuoc(sanPham.getMucChongNuoc());
                updateProduct.setBoSuuTap(sanPham.getBoSuuTap());

                productRepository.save(updateProduct);
            }
        }

        return "redirect:/admin/product/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBrand(@PathVariable("id") Long id) {

        return "redirect:/admin/brand/";
    }

}

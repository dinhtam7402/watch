package com.elevengroup.watch.controller.admin;

import com.elevengroup.watch.entity.ThuongHieu;
import com.elevengroup.watch.repository.BrandRepository;
import com.elevengroup.watch.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/admin/brand")
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewBrand(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size, Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ThuongHieu> pageTuts = brandRepository.findAll(pageable);
        model.addAttribute("brands", pageTuts.getContent());
        model.addAttribute("currentPage", pageTuts.getNumber() + 1);
        model.addAttribute("totalPages", pageTuts.getTotalPages());
        model.addAttribute("pageSize", size);

        return "admin/brand/brand";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBrand(Model model) {
        model.addAttribute("brand", new ThuongHieu());
        return "admin/brand/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBrandNew(@ModelAttribute("brand") ThuongHieu thuongHieu) {
        brandService.saveBrand(thuongHieu);
        return "redirect:/admin/brand/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("brand", brandRepository.findById(id).orElse(null));
        return "admin/brand/update";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateBrand(@PathVariable("id") Long id, @Valid ThuongHieu thuongHieu, BindingResult result) {
        if (result.hasErrors()) {
            thuongHieu.setMaThuongHieu(id);
            return "admin/brand/update";
        } else {
            Optional<ThuongHieu> existingThuongHieuOptional = brandRepository.findById(id);

            if (existingThuongHieuOptional.isPresent()) {
                ThuongHieu updateBrand = existingThuongHieuOptional.get();

                updateBrand.setTenThuongHieu(thuongHieu.getTenThuongHieu());
                updateBrand.setSoDienThoai(thuongHieu.getSoDienThoai());
                updateBrand.setDiaChi(thuongHieu.getDiaChi());
                updateBrand.setEmail(thuongHieu.getEmail());

                brandRepository.save(updateBrand);
            }
        }

        return "redirect:/admin/brand/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBrand(@PathVariable("id") Long id) {
        brandService.deleteById(id);
        return "redirect:/admin/brand/";
    }
}

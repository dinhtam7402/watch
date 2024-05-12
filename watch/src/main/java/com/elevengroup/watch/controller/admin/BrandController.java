package com.elevengroup.watch.controller.admin;

import com.elevengroup.watch.entity.ThuongHieu;
import com.elevengroup.watch.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/admin/brand")
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @RequestMapping(value = "/")
    public String viewBrand(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "20") int size, Model model) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<ThuongHieu> pageTuts = brandRepository.findAll(pageable);
        model.addAttribute("brands", pageTuts.getContent());
        model.addAttribute("currentPage", pageTuts.getNumber() + 1);
        model.addAttribute("totalPages", pageTuts.getTotalPages());
        model.addAttribute("pageSize", size);

        return "admin/brand";
    }
}

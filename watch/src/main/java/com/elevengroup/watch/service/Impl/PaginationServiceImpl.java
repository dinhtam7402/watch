package com.elevengroup.watch.service.Impl;

import com.elevengroup.watch.service.PaginationService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PaginationServiceImpl implements PaginationService {
    @Override
    public void addPaginationToModel(Page<?> page, Model model, int size, String requestURI) {
        int totalPages = page.getTotalPages();
        int currentPage = page.getNumber() + 1;

        model.addAttribute("Entities", page.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);

        int startPage = 1;
        int endPage = totalPages;

        if (totalPages > 5) {
            if (currentPage <= 3) {
                endPage = 5;
            } else if (currentPage >= totalPages - 2) {
                startPage = totalPages - 4;
            } else {
                startPage = currentPage - 2;
                endPage = currentPage + 2;
            }
        }

        List<Integer> pageNumbers = IntStream.rangeClosed(startPage, endPage).boxed().collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("requestURI", requestURI);
    }
}

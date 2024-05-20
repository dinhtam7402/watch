package com.elevengroup.watch.service;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public interface PaginationService {
    void addPaginationToModel(Page<?> page, Model model, int size, String requestURI);
}

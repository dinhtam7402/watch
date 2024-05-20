package com.elevengroup.watch.controller.admin;

import com.elevengroup.watch.entity.Customer;
import com.elevengroup.watch.repository.CustomerRepository;
import com.elevengroup.watch.service.CustomerService;
import com.elevengroup.watch.service.PaginationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("admin/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaginationService paginationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listCustomer(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "15") int size,
                               HttpServletRequest request,
                               Model model) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Customer> pageCustomer = customerService.getAllCustomers(pageable);

        paginationService.addPaginationToModel(pageCustomer, model, size, request.getRequestURI());

        return "admin/customer/list";
    }
}

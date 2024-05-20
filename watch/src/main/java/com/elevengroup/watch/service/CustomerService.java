package com.elevengroup.watch.service;

import com.elevengroup.watch.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> getAllCustomers(Pageable pageable);
}

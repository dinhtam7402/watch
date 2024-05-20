package com.elevengroup.watch.service;

import com.elevengroup.watch.entity.Customer;
import com.elevengroup.watch.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    Page<Orders> getAllOrders(Pageable pageable);
    Orders getOrderById(String id);
}

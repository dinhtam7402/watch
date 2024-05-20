package com.elevengroup.watch.service.Impl;

import com.elevengroup.watch.entity.Orders;
import com.elevengroup.watch.repository.OrderRepository;
import com.elevengroup.watch.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<Orders> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Orders getOrderById(String id) {
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        return optionalOrders.orElse(null);
    }
}

package com.elevengroup.watch.controller.admin.api;


import com.elevengroup.watch.entity.Orders;
import com.elevengroup.watch.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/orders")
public class OrdersApi {

    @Autowired
    private OrderService orderService;

    @GetMapping("/view/{id}")
    public ResponseEntity<Orders> getOrderDetails(@PathVariable("id") String id) {
        Orders orders = orderService.getOrderById(id);
        if (orders != null) {
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

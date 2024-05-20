package com.elevengroup.watch.controller.admin;

import com.elevengroup.watch.entity.Orders;
import com.elevengroup.watch.service.OrderService;
import com.elevengroup.watch.service.PaginationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaginationService paginationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listOrder(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "15") int size,
                            HttpServletRequest request,
                            Model model) {

        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Orders> pageOrders = orderService.getAllOrders(pageable);

        paginationService.addPaginationToModel(pageOrders, model, size, request.getRequestURI());

        return "admin/order/list";
    }

}

package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ho.godex.domain.Order;
import ua.ho.godex.service.OrderService;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrderController {
    final private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrders(Model model) {
        List<Order> orderList = orderService.getAll();
        model.addAttribute("orders", orderList);
        return "/orders/orders-list";
    }

}

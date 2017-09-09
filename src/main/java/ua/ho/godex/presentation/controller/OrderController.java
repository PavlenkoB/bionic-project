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
@RequestMapping(OrderController.MAIN_URL)
public class OrderController {
    final static String MAIN_URL = "/admin/orders/";
    final static String DELETE_URL = "{orderId}/delete";
    final static String DELETE_URL_PV = "orderId";
    final static String LIST_PAGE = "/order/orders-list";
    final private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrders(Model model) {
        List<Order> orderList = orderService.getAll();
        model.addAttribute("orders", orderList);
        return LIST_PAGE;
    }

}

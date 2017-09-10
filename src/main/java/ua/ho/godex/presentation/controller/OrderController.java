package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Order;
import ua.ho.godex.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(OrderController.MAIN_URL)
@SessionAttributes("currentOrder")
public class OrderController {
    final static String MAIN_URL = "/orders/";
    final static String ADMIN_URL = "admin/orders/";

    final static String DELETE_URL = "{orderId}/delete";
    final static String DELETE_URL_PV = "orderId";


    final static String BASKET_URL = "basket/";
    final static String BASKET_JSP = "/order/basket";
    final static String ADD_TO_BASKET_URL = "{productId}/addToBasket";
    final static String ADD_TO_BASKET_URL_PV = "productId";
    final static String BASKET_DEL_URL = "delFromBasket";

    final static String LIST_JSP = "/order/orders-list";


    final private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrders(Model model) {
        List<Order> orderList = orderService.getAll();
        model.addAttribute("orders", orderList);
        return LIST_JSP;
    }

    @GetMapping(BASKET_URL)
    public String showBasket(Model model,
                             @SessionAttribute("currentOrder") Order currentOrder
    ) {
        model.addAttribute("order", currentOrder);
        return BASKET_JSP;
    }

    @PostMapping(BASKET_URL + BASKET_DEL_URL)
    public String removeProductFromBasket(Model model,
                                          @RequestParam("indexInOrder") int indexInOrder,
                                          @SessionAttribute("currentOrder") Order currentOrder
    ) {
        currentOrder.getProducts().remove(indexInOrder);
        model.addAttribute("order", currentOrder);
        return "redirect:" + MAIN_URL + BASKET_URL;
    }

    @RequestMapping(ADD_TO_BASKET_URL)
    public String addToBasket(@PathVariable(ADD_TO_BASKET_URL_PV) Integer productId,
                              @SessionAttribute("currentOrder") Order currentOrder,
                              HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        orderService.addProductToOrder(currentOrder, productId);
        return "redirect:" + referrer;
    }

}

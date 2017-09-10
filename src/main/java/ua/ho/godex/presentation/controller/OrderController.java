package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Order;
import ua.ho.godex.domain.Product;
import ua.ho.godex.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(OrderController.MAIN_URL)
@SessionAttributes("currentOrder")
public class OrderController {
    final static String MAIN_URL = "/orders/";
    final static String ADMIN_URL = "admin/";

    final static String DELETE_URL = ADMIN_URL + "{orderId}/delete";
    final static String DELETE_URL_PV = "orderId";

    final static String CLOSE_URL = ADMIN_URL + "{orderId}/close";
    final static String CLOSE_URL_PV = "orderId";


    final static String BASKET_URL = "basket/";
    final static String ADD_TO_BASKET_URL = "{productId}/addToBasket";
    final static String ADD_TO_BASKET_URL_PV = "productId";
    final static String BASKET_DEL_URL = "delFromBasket";
    final static String BASKET_SAVE_URL = "saveBasket";
    final static String BASKET_CLEANBASKET_URL = "cleanBasket";

    final static String BASKET_JSP = "/order/basket";
    final static String LIST_JSP = "/order/orders-list";


    final private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrders(Model model) {
        //todo user orders
        Integer userId = 1;
        List<Order> orderList = orderService.getAllForUser(userId);
        model.addAttribute("orders", orderList);
        return LIST_JSP;
    }

    @GetMapping(ADMIN_URL)
    public String showOrdersAdmin(Model model) {
        List<Order> orderList = orderService.getAll();
        model.addAttribute("orders", orderList);
        return LIST_JSP;
    }

    @GetMapping(DELETE_URL)
    public String deleteOrdersAdmin(Model model,
                                    @PathVariable(DELETE_URL_PV) Integer orderId,
                                    HttpServletRequest request) {
        orderService.delete(orderId);
        String referrer = request.getHeader("referer");
        return "redirect:" + referrer;
    }

    @GetMapping(CLOSE_URL)
    public String closeOrdersAdmin(Model model,
                                   @PathVariable(CLOSE_URL_PV) Integer orderId,
                                   HttpServletRequest request) {
        Order order = orderService.getById(orderId);
        order.setLocalDateTimeClosed(LocalDateTime.now());
        orderService.update(order);
        String referrer = request.getHeader("referer");
        return "redirect:" + referrer;
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
                                          @SessionAttribute("currentOrder") Order currentOrder,
                                          HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        currentOrder.getProducts().remove(indexInOrder);
        model.addAttribute("order", currentOrder);
        return "redirect:" + referrer;
    }

    @RequestMapping(ADD_TO_BASKET_URL)
    public String addToBasket(@PathVariable(ADD_TO_BASKET_URL_PV) Integer productId,
                              @SessionAttribute("currentOrder") Order currentOrder,
                              HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        orderService.addProductToOrder(currentOrder, productId);
        return "redirect:" + referrer;
    }

    @RequestMapping(BASKET_URL + BASKET_SAVE_URL)
    public String saveBasket(
            Model model,
            @SessionAttribute("currentOrder") Order currentOrder
    ) {
        currentOrder.setLocalDateTimeOpen(LocalDateTime.now());
        orderService.update(currentOrder);
        currentOrder = new Order();
        model.addAttribute("currentOrder", currentOrder);
        return "redirect:" + MAIN_URL + BASKET_URL + BASKET_CLEANBASKET_URL;
    }

    @RequestMapping(BASKET_URL + BASKET_CLEANBASKET_URL)
    public String clanBasket(
            @SessionAttribute("currentOrder") Order currentOrder,
            HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        currentOrder.setTotalAmount(new BigDecimal(0));
        currentOrder.setProducts(new ArrayList<Product>());
        return "redirect:" + referrer;
    }

}

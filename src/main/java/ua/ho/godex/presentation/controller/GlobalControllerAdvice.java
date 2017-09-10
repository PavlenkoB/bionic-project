package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.ho.godex.domain.Category;
import ua.ho.godex.domain.Order;
import ua.ho.godex.domain.User;
import ua.ho.godex.service.CategoryService;
import ua.ho.godex.service.UserService;
import ua.ho.godex.service.VariantService;
import ua.ho.godex.util.MenuUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 09.09.2017
 * Project: supStore
 */
@ControllerAdvice
public class GlobalControllerAdvice {

    private final CategoryService categoryService;
    private final UserService userService;

    @Autowired
    public GlobalControllerAdvice(CategoryService categoryService, VariantService variantService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @ModelAttribute("currentOrder")
    public Order createBasket() {
        Order order = new Order();
        //todo rewrite
        User user = userService.getById(1);
        order.setUser(user);
        return order;
    }

    @ModelAttribute("categorysMenu")
    public List<Category> categorysMenu(HttpServletRequest request) {
        List<Category> categoryList = categoryService.getAll();
        List<Category> categories = MenuUtils.createHierarchic(categoryList);
        request.getSession().setAttribute("categorysMenu", categories);
        return categories;
        //todo meybi something wrong
    }
}

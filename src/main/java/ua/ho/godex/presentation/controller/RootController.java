package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.ho.godex.domain.User;
import ua.ho.godex.service.UserService;
import ua.ho.godex.service.VariantService;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
@Controller
public class RootController {
    private final UserService userService;

    @Autowired
    public RootController(UserService userService, VariantService variantService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "index";
    }
}

package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.ho.godex.service.UserService;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
@Controller
public class RootController {

    UserService userService;

    @Autowired
    public RootController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showMainPage(Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }
}

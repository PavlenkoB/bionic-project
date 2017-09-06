package ua.ho.godex.presentation.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.ho.godex.domain.Role;
import ua.ho.godex.domain.User;
import ua.ho.godex.service.GenericService;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 06.09.2017
 * Project: supStore
 */
public abstract class GenericController {
    protected GenericService genericService;

    public GenericController(GenericService genericService) {
        this.genericService = genericService;
    }

    @GetMapping
    public String showUsers(Model model) {
        List<User> userList = genericService.getAll();
        if (!model.containsAttribute("newUser")) {
            model.addAttribute("newUser", new User());
        }
        model.addAttribute("users", userList);
        model.addAttribute("userRoles", Role.values());
        return "/users/users-list";
    }
}

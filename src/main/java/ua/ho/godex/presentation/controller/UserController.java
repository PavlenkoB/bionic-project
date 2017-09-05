package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ho.godex.domain.User;
import ua.ho.godex.service.UserService;

import java.util.List;

@Controller
@RequestMapping(UserController.MAIN_URL)
public class UserController {
    final static String MAIN_URL = "/admin/users";
    final static String DELETE_URL = "/{userId}/delete";
    final static String DELETE_URL_PV = "userId";
    final static String EDIT_URL = "/{userId}/edit";
    final static String EDIT_URL_PV = "userId";
    final private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("users", userList);
        return "/users/users-list";
    }
}

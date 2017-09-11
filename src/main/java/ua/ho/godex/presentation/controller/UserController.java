package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Role;
import ua.ho.godex.domain.User;
import ua.ho.godex.service.UserService;

import java.util.List;

@Controller
@RequestMapping(UserController.MAIN_URL)
public class UserController {
    final static String MAIN_URL = "/users/";
    final static String ADMIN_URL = "/admin/users/";
    final static String REGISTER_URL = "register";
    final static String REGISTER_PAGE = "/users/register";
    final static String DELETE_URL = ADMIN_URL + "/{userId}/delete";
    final static String DELETE_URL_PV = "userId";
    final static String EDIT_URL = ADMIN_URL + "/{userId}/edit";
    final static String EDIT_URL_PV = "userId";
    final static String LIST_JSP_PAGE = "/users/users-list";
    final private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsers(Model model) {
        List<User> userList = userService.getAll();
        if (!model.containsAttribute("newUser")) {
            model.addAttribute("newUser", new User());
        }
        model.addAttribute("users", userList);
        model.addAttribute("userRoles", Role.values());

        return LIST_JSP_PAGE;
    }

    @GetMapping(REGISTER_URL)
    public String startRegisterUsers(Model model) {
        List<User> userList = userService.getAll();
        if (!model.containsAttribute("newUser")) {
            model.addAttribute("newUser", new User());
        }
        model.addAttribute("users", userList);
        model.addAttribute("userRoles", Role.values());

        return REGISTER_PAGE;
    }

    @PostMapping(REGISTER_URL)
    public String addRegisterUsers(Model model,
                                   @ModelAttribute("newUser") User newUser) {
        userService.update(newUser);
        return "redirect:" + RootController.MAIN_URL;
    }

    @PostMapping(EDIT_URL)
    public String editUsers(Model model,
                            @PathVariable(EDIT_URL_PV) Integer userId,
                            @ModelAttribute("newUser") User newUser) {
        boolean saveUser = newUser.getId() != null;
        User user = userService.getById(userId);
        user.setRole(Role.USER);
        model.addAttribute("newUser", user);
        if (!saveUser) {
            return LIST_JSP_PAGE;
        } else {
            userService.update(newUser);
            return "redirect:" + UserController.MAIN_URL;
        }
    }

    @PostMapping
    String addUser(Model model,
                   @ModelAttribute("newUser") User newUser) {
        //todo cheack input date
        userService.create(newUser);
        return "redirect:" + UserController.MAIN_URL;
    }

    @PostMapping(DELETE_URL)
    String addUser(Model model,
                   @PathVariable(DELETE_URL_PV) Integer userId) {
        //todo cheack input date
        userService.delete(userId);
        return "redirect:" + UserController.MAIN_URL;
    }

}

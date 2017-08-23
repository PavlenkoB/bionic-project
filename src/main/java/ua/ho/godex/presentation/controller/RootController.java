package ua.ho.godex.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
@Controller
public class RootController {
    @GetMapping("/")
    public String showMainPage(){
        return "index";
    }
}

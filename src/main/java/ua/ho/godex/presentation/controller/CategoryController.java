package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ho.godex.domain.Category;
import ua.ho.godex.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping("categorys")
public class CategoryController {
    final private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showCategorys(Model model) {
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categorys", categoryList);
        return "/categorys/categorys-list";
    }

}

package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ho.godex.domain.Category;
import ua.ho.godex.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(CategoryController.MAIN_URL)
public class CategoryController {
    final static String MAIN_URL = "/admin/categorys/";
    final static String DELETE_URL = "/{categoryId}/delete";
    final static String DELETE_URL_PV = "categoryId";
    final private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showCategorys(Model model) {
        List<Category> categoryList = categoryService.getAll();
        Map<Integer, Category> integerCategoryHashMap = categoryList.stream().collect(Collectors.toMap(Category::getId, Category::getSelf));
        for (Category category : categoryList) {
            Integer parentCatId = category.getParentCatId();
            if (parentCatId != null) {
                integerCategoryHashMap.get(parentCatId).getChildren().add(category);
            }
        }
        List<Category> categories = new ArrayList<>();
        for (Category category : categoryList) {
            Integer parentCatId = category.getParentCatId();
            if (parentCatId == null) {
                categories.add(category);
            }
        }
        model.addAttribute("categorys", categories);
        return "/category/category-list";
    }

    @PostMapping(DELETE_URL)
    String deleteCategory(Model model, @PathVariable(DELETE_URL_PV) Integer categoryId) {
        categoryService.delete(categoryId);
        return "redirect:" + AttributeController.MAIN_URL;
    }
}

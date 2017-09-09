package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.ho.godex.domain.Category;
import ua.ho.godex.domain.Order;
import ua.ho.godex.service.CategoryService;
import ua.ho.godex.service.VariantService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Creator: Pavlenko Bohdan
 * Date: 09.09.2017
 * Project: supStore
 */
@ControllerAdvice
public class GlobalControllerAdvice {


    private final CategoryService categoryService;

    @Autowired
    public GlobalControllerAdvice(CategoryService categoryService, VariantService variantService) {
        this.categoryService = categoryService;
    }


    @ModelAttribute("currentOrder")
    public Order createBasket() {
        return new Order();
    }

    @ModelAttribute("categorysMenu")
    public List<Category> categorysMenu(HttpServletRequest request) {
        List<Category> categoryList = categoryService.getAll();
        //todo use ordering
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
        request.getSession().setAttribute("categorysMenu", categories);
        return categories;
    }
}

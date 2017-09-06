package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Category;
import ua.ho.godex.service.CategoryService;
import ua.ho.godex.service.VariantService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
@Controller
@SessionAttributes("categorysMenu")
public class RootController {
    private final CategoryService categoryService;

    @Autowired
    public RootController(CategoryService categoryService, VariantService variantService) {
        this.categoryService = categoryService;
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

    @GetMapping("/")
    public String showMainPage(Model model) {
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
        model.addAttribute("categorysMenu", categories);
        return "index";
    }

    @RequestMapping("/*")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String customize404() {
        return "/errors/404";
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
            }
        };
    }
}

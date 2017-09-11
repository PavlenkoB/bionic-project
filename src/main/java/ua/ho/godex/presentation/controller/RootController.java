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
import ua.ho.godex.domain.Product;
import ua.ho.godex.dto.ProductSort;
import ua.ho.godex.service.CategoryService;
import ua.ho.godex.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 23.08.2017
 * Project: istore
 */
@Controller
@SessionAttributes({"categorysMenu", "currentOrder"})
public class RootController {
    final static String MAIN_URL = "/";
    final static String SEARCH_URL = "search";
    ProductService productService;

    private final int PAGE_SIZE = 5;
    private CategoryService categoryService;

    @Autowired
    public RootController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping(MAIN_URL)
    public String searchMainPage(Model model,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "minPrice", required = false) BigDecimal min,
                                 @RequestParam(value = "maxPrice", required = false) BigDecimal max,
                                 @RequestParam(value = "sort", required = false) ProductSort sort,
                                 @RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "categoryId", required = false) Integer categoryId
    ) {
        int offset = (page - 1) * PAGE_SIZE;
        int limit = PAGE_SIZE;
        if (sort == null) sort = ProductSort.NAME_ASC;
        List<Product> products = productService.getAll(name, min, max, sort, offset, limit, categoryId);
        model.addAttribute("products", products);
        int count = productService.getCount(name, min, max, categoryId);
        model.addAttribute("productCount", count);
        model.addAttribute("categorys", categoryService.getAll());
        model.addAttribute("pageSize", PAGE_SIZE);
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

package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ho.godex.domain.Product;
import ua.ho.godex.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(ProductController.MAIN_URL)
public class ProductController {
    final static String MAIN_URL = "/admin/products";
    final static String DELETE_URL = "/{categoryId}/delete";
    final static String DELETE_URL_PV = "categoryId";

    final private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProducts(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("products", productList);
        return "/products/list";
    }

}

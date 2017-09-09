package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Category;
import ua.ho.godex.domain.Product;
import ua.ho.godex.domain.Variant;
import ua.ho.godex.service.CategoryService;
import ua.ho.godex.service.ProductService;
import ua.ho.godex.service.VariantService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(ProductController.MAIN_URL)
public class ProductController {
    final static String MAIN_URL = "/admin/products/";
    final static String EDIT_URL = "{productId}/edit";
    final static String EDIT_URL_PV = "productId";
    final static String DELETE_URL = "{productId}/delete";
    final static String DELETE_URL_PV = "productId";

    final static String EDIT_PAGE = "/products/edit_product";
    final static String LIST_PAGE = "/products/list";
    final static String ADD_PAGE = "/products/add_product";

    final private ProductService productService;
    final private CategoryService categoryService;
    final private VariantService variantService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, VariantService variantService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.variantService = variantService;
    }

    @GetMapping
    public String showProducts(Model model) {
        List<Product> productList = productService.getAll();
        model.addAttribute("categorys", categoryService.getAll());
        model.addAttribute("products", productList);
        return LIST_PAGE;
    }

    @PostMapping("/add")
    public String addProduct(Model model,
                             @RequestParam(value = "categoryId") Integer categoryId) {
        Category category = categoryService.getById(categoryId);
        model.addAttribute("category", category);
        model.addAttribute("newProduct", new Product());
        return ADD_PAGE;
    }

    @PostMapping({"/save", "{pridId}/save"})
    @Transactional
    public String saveProduct(Model model,
                              @RequestParam Map<String, String> allRequestParams,
                              @RequestParam("category-id") Integer categoryId,
                              @ModelAttribute("newProduct") Product newProduct) {
        List<Variant> variants = new ArrayList<>();
        List<Map.Entry<String, String>> collect = allRequestParams.entrySet().stream()
                .filter(stringStringEntry -> stringStringEntry.getKey().contains("attr-"))
                .collect(Collectors.toList());
        for (Map.Entry<String, String> stringEntry : collect) {
            Integer variantId = Integer.valueOf(stringEntry.getValue());
            variants.add(variantService.getById(variantId));
        }
        newProduct.setCategory(categoryService.getById(categoryId));
        newProduct.setVariants(variants);
        productService.update(newProduct);
        return "redirect:" + MAIN_URL;
    }

    @RequestMapping(EDIT_URL)
    public String editProduct(
            Model model,
            @PathVariable(EDIT_URL_PV) Integer productId
    ) {
        Product productServiceById = productService.getById(productId);
        model.addAttribute("newProduct", productServiceById);
        model.addAttribute("category", productServiceById.getCategory());
        return ADD_PAGE;
    }

    @PostMapping(DELETE_URL)
    @Transactional
    public String showProducts(Model model,
                               @PathVariable(DELETE_URL_PV) Integer productId) {
        productService.delete(productId);
        return "redirect:" + MAIN_URL;
    }
}

package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Category;
import ua.ho.godex.service.CategoryService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(CategoryController.MAIN_URL)
@SessionAttributes("currentOrder")
public class CategoryController {
    final static String MAIN_URL = "categorys/";
    final static String ADMIN_URL = "admin/";

    final static String DELETE_URL = ADMIN_URL + "/{categoryId}/delete";
    final static String DELETE_URL_PV = "categoryId";

    final static String EDIT_URL = ADMIN_URL + "/{categoryId}/edit";
    final static String EDIT_URL_PV = "categoryId";

    final static String ADD_URL = ADMIN_URL + "/{categoryId}/add";
    final static String ADD_URL_PV = "categoryId";
    final static String ADD_PAGE = "/category/add";

    final static String UP_URL = ADMIN_URL + "/{categoryId}/up";
    final static String UP_URL_PV = "categoryId";

    final static String DOWN_URL = ADMIN_URL + "{categoryId}/down";
    final static String DOWN_URL_PV = "categoryId";

    final static String CATEGORY_LIST = "{categoryId}";
    final static String CATEGORY_LIST_PV = "categoryId";
    final static String CATEGORY_PAGE = "/products/list";


    final private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(ADMIN_URL)
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

    @PostMapping(UP_URL)
    String upCategory(Model model, @PathVariable(UP_URL_PV) Integer categoryId,
                      HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        Category category = categoryService.getById(categoryId);
        if (category.getOrder() > 0) {
            category.setOrder(category.getOrder() - 1);
            categoryService.update(category);
        }

        return "redirect:" + referrer;
    }

    @PostMapping(DOWN_URL)
    @Transactional
    String downCategory(Model model, @PathVariable(DOWN_URL_PV) Integer categoryId,
                        HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        Category category = categoryService.getById(categoryId);
        category.setOrder(category.getOrder() + 1);
        categoryService.update(category);
        return "redirect:" + referrer;
    }


    @PostMapping(DELETE_URL)
    String deleteCategory(Model model, @PathVariable(DELETE_URL_PV) Integer categoryId,
                          HttpServletRequest request) {
        String referrer = request.getHeader("referer");
        categoryService.delete(categoryId);
        return "redirect:" + referrer;
    }

    @PostMapping(EDIT_URL)
    String editCategory(Model model, @PathVariable(EDIT_URL_PV) Integer categoryId) {
        Category category = categoryService.getById(categoryId);
        model.addAttribute("category", category);
        return ADD_PAGE;
    }

    @GetMapping(CATEGORY_LIST)
    String productsInCategory(Model model,
                              @PathVariable(CATEGORY_LIST_PV) Integer categoryId
    ) {
        Category category = categoryService.getById(categoryId);
        model.addAttribute("category", category);
        model.addAttribute("products", category.getProductList());
        return CATEGORY_PAGE;
    }
}

package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Category;
import ua.ho.godex.service.CategoryService;
import ua.ho.godex.util.MenuUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(CategoryController.MAIN_URL)
@SessionAttributes("currentOrder")
public class CategoryController {
    final static String MAIN_URL = "categorys/";
    final static String ADMIN_URL = "admin/";

    final static String DELETE_URL = ADMIN_URL + "{categoryId}/delete";
    final static String DELETE_URL_PV = "categoryId";

    final static String EDIT_URL = ADMIN_URL + "{categoryId}/edit";
    final static String EDIT_URL_PV = "categoryId";

    final static String ADD_URL = ADMIN_URL + "{categoryId}/add";
    final static String ADD_URL_PV = "categoryId";
    final static String ADD_PAGE = "/category/add_page";

    final static String UP_URL = ADMIN_URL + "{categoryId}/up";
    final static String UP_URL_PV = "categoryId";

    final static String DOWN_URL = ADMIN_URL + "{categoryId}/down";
    final static String DOWN_URL_PV = "categoryId";

    final static String CATEGORY_LIST = "{categoryId}";
    final static String CATEGORY_LIST_PV = "categoryId";
    final static String CATEGORY_PAGE = "/products/list";

    final static String SAVE_URL = ADMIN_URL + "{categoryId}/save";
    final static String SAVE_URL_PV = "categoryId";


    final private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(ADMIN_URL)
    public String showCategorys(Model model) {
        List<Category> categoryList = categoryService.getAll();
        List<Category> hierarchic = MenuUtils.createHierarchic(categoryList);
        model.addAttribute("categorys", hierarchic);
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
        model.addAttribute("editedCategory", category);
        model.addAttribute("categorys", categoryService.getAll());
        return ADD_PAGE;
    }

    @PostMapping(SAVE_URL)
    public String saveCategory(Model model,
                               @ModelAttribute("editedCategory") Category newCategory,
                               @PathVariable(SAVE_URL_PV) Integer categoryId,
                               @ModelAttribute("parentCategoryId") Integer parentCatId) {
        newCategory.setParentCatId(parentCatId);
        categoryService.update(newCategory);
        return "redirect:" + MAIN_URL + ADMIN_URL;
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

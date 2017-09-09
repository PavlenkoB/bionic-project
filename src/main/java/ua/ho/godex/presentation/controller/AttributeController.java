package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.domain.FieldType;
import ua.ho.godex.service.AttributeService;
import ua.ho.godex.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping(AttributeController.MAIN_URL)
public class AttributeController {
    final static String MAIN_URL = "attributes/";
    final static String ADMIN_URL = "admin/attributes/";
    final static String DELETE_URL = "/{attributeId}/delete";
    final static String DELETE_URL_PV = "attributeId";
    final static String EDIT_URL = "/{attributeId}/edit";
    final static String EDIT_URL_PV = "attributeId";
    final private AttributeService attributeService;
    final private CategoryService categoryService;

    @Autowired
    public AttributeController(AttributeService attributeService, CategoryService categoryService) {
        this.attributeService = attributeService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String showAttributes(Model model) {
        List<Attribute> attributeList = attributeService.getAll();
        if (!model.containsAttribute("newAttribute")) {
            model.addAttribute("newAttribute", new Attribute());
        }
        model.addAttribute("attributes", attributeList);
        model.addAttribute("categorys", categoryService.getAll());
        model.addAttribute("fieldtypes", FieldType.values());
        return "/attribute/attribute-list";
    }

    @PostMapping
    String addAttribute(Model model,
                        @ModelAttribute("newAttribute") Attribute newAttribute,
                        @RequestParam(value = "categoryId", required = true) Integer categoryId) {
        //todo cheack input date
        newAttribute.setCategory(categoryService.getById(categoryId));
        attributeService.create(newAttribute);
        return "redirect:" + AttributeController.MAIN_URL;
    }

    @PostMapping(EDIT_URL)
    String editAttribute(Model model,
                         @PathVariable(value = EDIT_URL_PV) Integer attributeId) {
        Attribute attribute = attributeService.getById(attributeId);
        model.addAttribute("newAttribute", attribute);
        return "redirect:" + AttributeController.MAIN_URL;
    }

    @PostMapping(DELETE_URL)
    String deleteAttribute(Model model, @PathVariable(DELETE_URL_PV) Integer attributeId) {
        attributeService.delete(attributeId);
        return "redirect:" + AttributeController.MAIN_URL;
    }
}

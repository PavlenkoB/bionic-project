package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.domain.FieldType;
import ua.ho.godex.domain.Variant;
import ua.ho.godex.service.AttributeService;
import ua.ho.godex.service.CategoryService;
import ua.ho.godex.service.VariantService;

import java.util.List;

@Controller
@RequestMapping(AttributeController.ADMIN_URL)
public class AttributeController {
    final static String MAIN_URL = "attributes/";
    final static String ADMIN_URL = "admin/attributes/";
    final static String ADD_URL = "add";
    final static String DELETE_URL = "{attributeId}/delete";
    final static String DELETE_URL_PV = "attributeId";
    final static String EDIT_URL = ADMIN_URL + "{attributeId}/edit";
    final static String EDIT_URL_PV = "attributeId";
    final private AttributeService attributeService;
    final private CategoryService categoryService;
    final private VariantService variantService;

    @Autowired
    public AttributeController(AttributeService attributeService, CategoryService categoryService, VariantService variantService) {
        this.attributeService = attributeService;
        this.categoryService = categoryService;
        this.variantService = variantService;
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

    @PostMapping(ADD_URL)
    String addAttribute(Model model,
                        @ModelAttribute("newAttribute") Attribute newAttribute,
                        @RequestParam(value = "categoryId", required = true) Integer categoryId) {

        //todo cheack input date
        newAttribute.setCategory(categoryService.getById(categoryId));
        List<Variant> variantList = newAttribute.getVariantList();
        if (variantList.isEmpty() && newAttribute.getFieldType().equals(FieldType.CHECK_BOX)) {
            variantList.add(new Variant("0", newAttribute));
            variantList.add(new Variant("1", newAttribute));
            newAttribute.setVariantList(variantList);
        }
        attributeService.update(newAttribute);
        newAttribute.getVariantList().forEach(variantService::update);
        return "redirect:/" + AttributeController.ADMIN_URL;
    }

    @PostMapping(EDIT_URL)
    String editAttribute(Model model,
                         @PathVariable(value = EDIT_URL_PV) Integer attributeId) {
        Attribute attribute = attributeService.getById(attributeId);
        model.addAttribute("newAttribute", attribute);
        return "redirect:/" + AttributeController.ADMIN_URL;
    }

    @PostMapping(DELETE_URL)
    String deleteAttribute(Model model, @PathVariable(DELETE_URL_PV) Integer attributeId) {
        attributeService.delete(attributeId);
        return "redirect:/" + AttributeController.ADMIN_URL;
    }
}

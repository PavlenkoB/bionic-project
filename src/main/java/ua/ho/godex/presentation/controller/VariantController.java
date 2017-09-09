package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.domain.Variant;
import ua.ho.godex.service.AttributeService;
import ua.ho.godex.service.VariantService;

import java.util.List;

@Controller
@RequestMapping(VariantController.MAIN_URL)
public class VariantController {
    final static String MAIN_URL = "/variants/";
    final static String ADMIN_URL = "/admin/variants/";
    final static String DELETE_URL = ADMIN_URL + "/{variantId}/delete";
    final static String DELETE_URL_PV = "variantId";
    final static String EDIT_URL = ADMIN_URL + "/{variantId}/edit";
    final static String EDIT_URL_PV = "variantId";

    final static String ATTRIBUTE_ADD_URL = "/{attributeId}/add";
    final static String ATTRIBUTE_ADD_URL_PV = "attributeId";
    final static String showVariantsForAttribute_URL = "/{attributeId}/add";
    final static String showVariantsForAttribute_URL_PV = "attributeId";
    final static String showVariantsForAttribute_PAGE = "/variant/variant-list";


    final static String showVariants_PAGE = "/variant/variant-list";


    final private VariantService variantService;
    final private AttributeService attributeService;

    @Autowired
    public VariantController(VariantService variantService, AttributeService attributeService) {
        this.variantService = variantService;
        this.attributeService = attributeService;
    }

    @GetMapping
    public String showVariants(Model model) {
        List<Variant> variantList = variantService.getAll();
        model.addAttribute("variants", variantList);
        if (!model.containsAttribute("newVariant")) {
            model.addAttribute("newVariant", new Variant());
        }
        return showVariants_PAGE;
    }

    @GetMapping(showVariantsForAttribute_URL)
    public String showVariantsForAttribute(Model model, @PathVariable(showVariantsForAttribute_URL_PV) Integer attributeId) {
        if (!model.containsAttribute("newVariant")) {
            model.addAttribute("newVariant", new Variant());
        }
        Attribute attributeServiceById = attributeService.getById(attributeId);
        model.addAttribute("attribute", attributeServiceById);
        model.addAttribute("variants", attributeServiceById.getVariantList());
        return showVariantsForAttribute_PAGE;
    }

    @PostMapping(ATTRIBUTE_ADD_URL)
    public String addVariantForAttribute(Model model,
                                         @PathVariable(ATTRIBUTE_ADD_URL_PV) Integer attributeId,
                                         @RequestParam(value = "name", required = true) String name,
                                         @RequestParam(value = "description", required = true) String description
    ) {
        //todo use binding parameter
        Attribute attributeServiceById = attributeService.getById(attributeId);
        Variant variant = new Variant();
        variant.setAttribute(attributeServiceById);
        variant.setName(name);
        variant.setDescription(description);
        variantService.create(variant);
        return "redirect:" + VariantController.MAIN_URL + "/" + attributeId + "/";
    }

    @PostMapping(DELETE_URL)
    String deleteAttribute(Model model, @PathVariable(DELETE_URL_PV) Integer variantId) {
        Integer attributeid = variantService.getById(variantId).getAttribute().getId();
        variantService.delete(variantId);
        return "redirect:" + VariantController.MAIN_URL + "/" + attributeid + "/";
    }
}

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
    final static String MAIN_URL = "/admin/variants";
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
        return "/variant/variant-list";
    }

    @GetMapping("/{attributeId}/")
    public String showVariantsForAttribute(Model model, @PathVariable("attributeId") Integer attributeId) {
        if (!model.containsAttribute("newVariant")) {
            model.addAttribute("newVariant", new Variant());
        }
        Attribute attributeServiceById = attributeService.getById(attributeId);
        model.addAttribute("attribute", attributeServiceById);
        model.addAttribute("variants", attributeServiceById.getVariantList());
        return "/variant/variant-list";
    }

    @PostMapping("/{attributeId}/add")
    public String addVariantForAttribute(Model model,
                                         @PathVariable("attributeId") Integer attributeId,
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

    @PostMapping("/{variantId}/delete")
    String deleteAttribute(Model model, @PathVariable("variantId") Integer variantId) {
        Variant variant = variantService.getById(variantId);
        //todo not working
        variantService.delete(variantId);
        return "redirect:" + VariantController.MAIN_URL + "/" + variant.getAttribute().getId() + "/";
    }
}

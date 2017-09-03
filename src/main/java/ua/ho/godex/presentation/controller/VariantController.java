package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ho.godex.domain.Variant;
import ua.ho.godex.service.VariantService;

import java.util.List;

@Controller
@RequestMapping("variants")
public class VariantController {
    final private VariantService variantService;

    @Autowired
    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @GetMapping
    public String showVariants(Model model) {
        List<Variant> variantList = variantService.getAll();
        model.addAttribute("variants", variantList);
        return "/variant/variant-list";
    }
}

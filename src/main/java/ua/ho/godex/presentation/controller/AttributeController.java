package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.service.AttributeService;

import java.util.List;

@Controller
@RequestMapping("/admin/attributes")
public class AttributeController {
    final private AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping
    public String showAttributes(Model model) {
        List<Attribute> attributeList = attributeService.getAll();
        if (!model.containsAttribute("newAttribute")) {
            model.addAttribute("newAttribute", new Attribute());
        }
        model.addAttribute("attributes", attributeList);
        return "/attribute/attribute-list";
    }

    @PostMapping
    String addAttribute(Model model, @ModelAttribute("newAttribute") Attribute newAttribute) {
        //todo cheack input date
        attributeService.create(newAttribute);
        return "redirect:/admin/attributes";
    }

    @PostMapping("/{attributeId}/delete")
    String deleteAttribute(Model model, @PathVariable("attributeId") Integer attributeId) {
        attributeService.delete(attributeId);
        return "redirect:/admin/attributes";
    }
}

package ua.ho.godex.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ho.godex.domain.Attribute;
import ua.ho.godex.service.AttributeService;

import java.util.List;

@Controller
@RequestMapping("attributes")
public class AttributeController {
    final private AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping
    public String showAttributes(Model model) {
        List<Attribute> attributeList = attributeService.getAll();
        model.addAttribute("attributes", attributeList);
        return "/attribute/attribute-list";
    }
}

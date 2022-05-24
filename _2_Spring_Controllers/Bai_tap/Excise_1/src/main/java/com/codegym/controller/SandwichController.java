package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping(value = "/")
    public String sandwichHome() {
        return "condiments";
    }

    @PostMapping(value = "/sandwich")
    public String selectedCondiments(
            @RequestParam(name = "condiments", required = false) String[] condiments,  Model model )
    {
        model.addAttribute("condiments",condiments);

        return "selectedChoice";
    }
}
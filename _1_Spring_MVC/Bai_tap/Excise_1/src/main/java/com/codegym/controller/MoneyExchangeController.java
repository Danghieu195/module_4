package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoneyExchangeController {
    @GetMapping("")
    public String exchange(){
        return "index";
    }

    @PostMapping("/exchange")
    public String calculateVND(@RequestParam double usd, @RequestParam double ratio, Model model) {
        double VND = usd * ratio;

//        model.addAttribute("usd",USD);
        model.addAttribute("ratio",ratio);
        model.addAttribute("VND",VND);

        return "result";
    }
}

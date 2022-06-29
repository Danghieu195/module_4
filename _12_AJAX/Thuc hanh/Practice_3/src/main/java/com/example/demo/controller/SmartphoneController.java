package com.example.demo.controller;

import com.example.demo.model.Smartphone;
import com.example.demo.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/smartphone")
public class SmartphoneController {

   @Autowired
    private ISmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone) {
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("")
    public String showShop(Model model) {
        List<Smartphone> smartphones = smartphoneService.findALl();
        model.addAttribute("smartphone", smartphones);
        return "home";
    }

    @GetMapping
    public ResponseEntity<List<Smartphone>> allPhones() {
        return new ResponseEntity<>(smartphoneService.findALl(), HttpStatus.OK);
    }
}

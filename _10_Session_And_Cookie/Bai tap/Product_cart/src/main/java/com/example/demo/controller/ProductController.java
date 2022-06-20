package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/shop")
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    //Neu session cart rong thi moi thuc hien phuong thuc setUpCar
    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping("")
    public String showShop(Model model, @PageableDefault(size = 2) Pageable pageable) {
        Page<Product> products = iProductService.findAll(pageable);
        model.addAttribute("products", products);
        return "list";
    }
}

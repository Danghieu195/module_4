package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Product;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

//    @GetMapping("")
//    public String showShop(Model model, @PageableDefault(size = 2) int pageable) {
//        Page<Product> products = iProductService.findAll(pageable);
//        model.addAttribute("products", products);
//        return "list";
//    }

    @GetMapping("")
    public String showShop(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Product> products = iProductService.findAll(PageRequest.of(page, 2));
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/{id}/view")
    public String viewProduct(@PathVariable Integer id, Model model){
        Optional<Product> product = iProductService.findByID(id);

        if(product.isPresent()) {
            model.addAttribute("product", product.get());
            return "view";
        } else {
            return "error";
        }
    }

    @ExceptionHandler(value = Exception.class)
    public String cannotDecrease() {
        return "error.404";
    }

}

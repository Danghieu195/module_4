package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserDTO;
import com.example.demo.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "create";
    }

    @PostMapping("/validateUser")
    public String create(@Validated @ModelAttribute(name = "userDTO") UserDTO userDTO, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        else {
            User user = new User();
            BeanUtils.copyProperties(userDTO, user);
            iUserService.save(user);
            return "result";
        }
    }
}

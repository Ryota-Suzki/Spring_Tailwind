package com.example.Tailwind_Demo.controller;

import com.example.Tailwind_Demo.model.User;
import com.example.Tailwind_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/settings")
    public String userSettings(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/settings";
    }
}
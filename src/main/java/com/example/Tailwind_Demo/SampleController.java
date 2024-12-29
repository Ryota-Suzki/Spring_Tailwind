package com.example.Tailwind_Demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class SampleController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Test User");
        return "index";
    }
}
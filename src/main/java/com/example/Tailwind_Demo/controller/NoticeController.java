package com.example.Tailwind_Demo.controller;

import com.example.Tailwind_Demo.model.Notice;
import com.example.Tailwind_Demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/home")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/notice")
    public String notice(Model model) {
        List<Notice> noticeList = noticeService.getAllNotice();
        model.addAttribute("noticeList", noticeList);
        return "/home/notice";
    }
}

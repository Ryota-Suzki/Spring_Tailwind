package com.example.Tailwind_Demo.controller;

import com.example.Tailwind_Demo.model.User;
import com.example.Tailwind_Demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;


@Controller
@RequestMapping

public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // POSTリクエストで登録処理
    @PostMapping("/register")
    public String registerUser(User user, BindingResult result, Model model) {
        // フォームのバリデーション結果を確認
        if (result.hasErrors()) {
            return "register";  // エラーがあれば、再度登録フォームを表示
        }

        // ユーザー登録処理（サービスクラスを通じてデータベースに保存）
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            // ユーザー名やメールアドレスが重複しているなどのエラーハンドリング
            model.addAttribute("error", "登録に失敗しました。もう一度お試しください。");
            return "register";  // 再度フォームに戻る
        }

        // 登録成功後は、ログインページにリダイレクト
        return "redirect:/login";
    }
}

package com.example.Tailwind_Demo.service;

import com.example.Tailwind_Demo.model.User;
import com.example.Tailwind_Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ユーザーの一覧を取得
    public List<com.example.Tailwind_Demo.model.User> getAllUsers() {
        return userRepository.findAll();
    }

    // IDでユーザーを取得
    public Optional<com.example.Tailwind_Demo.model.User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // ユーザーを保存
    public void saveUser(User user) {
        String testPassword = "test123";
        String encodedTestPassword = passwordEncoder.encode(testPassword);
        System.out.println("Encoded test password: " + encodedTestPassword);

        System.out.println("Before encoding: " + user.getPassword());  // ここで元のパスワードを確認
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println("Encoded password: " + encodedPassword);  // ハッシュ化されたパスワードを確認
        user.setPassword(encodedPassword);  // エンコードされたパスワードをセット
        System.out.println("After setting encoded password: " + user.getPassword());  // エンコード後のパスワードを確認
        userRepository.save(user);  // ユーザーを保存
    }

    // メールでユーザーを検索
    public com.example.Tailwind_Demo.model.User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // UserDetailsService の実装
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.example.Tailwind_Demo.model.User user = userRepository.findByEmail(email);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        // Spring Security 用の UserDetails を生成して返す
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail()) // 認証に使うフィールド
                .password(user.getPassword()) // ハッシュ化されたパスワード
                .roles("USER") // ロールを設定（必要に応じて変更）
                .build();
    }
}

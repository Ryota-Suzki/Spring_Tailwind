package com.example.Tailwind_Demo.service;

import com.example.Tailwind_Demo.model.Notice;
import com.example.Tailwind_Demo.model.User;
import com.example.Tailwind_Demo.repository.NoticeRepository;
import com.example.Tailwind_Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    // お知らせの一覧を取得
    public List<Notice> getAllNotice() {
        return noticeRepository.findAll();
    }

}

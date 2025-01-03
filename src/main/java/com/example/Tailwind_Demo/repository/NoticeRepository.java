package com.example.Tailwind_Demo.repository;

import com.example.Tailwind_Demo.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}

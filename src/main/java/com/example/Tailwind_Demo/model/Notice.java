package com.example.Tailwind_Demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "notice")
@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String importance;
    private String area;
    private String content;
    private String issueDate;
}

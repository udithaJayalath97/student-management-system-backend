package com.example.student_management_system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String code;
    private String description;
    private int credits;
}

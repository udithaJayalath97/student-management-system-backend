package com.example.student_management_system.dto;

import lombok.Data;

@Data
public class CreateCourseDTO {
    private String title;
    private String code;
    private String description;
    private int credits;
}

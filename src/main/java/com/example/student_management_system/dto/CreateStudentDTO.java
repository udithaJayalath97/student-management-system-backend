package com.example.student_management_system.dto;

import lombok.Data;

@Data
public class CreateStudentDTO {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}

package com.example.student_management_system.controller;

import com.example.student_management_system.dto.CreateCourseDTO;
import com.example.student_management_system.dto.CreateStudentDTO;
import com.example.student_management_system.model.Course;
import com.example.student_management_system.model.Enrollment;
import com.example.student_management_system.model.Result;
import com.example.student_management_system.model.Student;
import com.example.student_management_system.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/getCourses")
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }

    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody CreateCourseDTO course) {
        return service.createCourse(course);
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return service.getCourseById(id);
    }

    @DeleteMapping("/courses/delete/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @PostMapping("/students/create")
    public Student createStudent(@RequestBody CreateStudentDTO student) {
        return service.createStudent(student);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @DeleteMapping("/students/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }

    @PostMapping("/student/Enrollment")
    public Enrollment enrollStudent(@RequestParam String studentId, @RequestParam String code) {
        return service.enrollStudent(studentId, code);
    }

    @GetMapping("/enrollments")
    public List<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }

    @GetMapping("/enrollments/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudent(@PathVariable Long studentId) {
        return service.getEnrollmentsByStudent(studentId);
    }

    @PostMapping("/results/add")
    public Result recordResult(@RequestParam String studentId, @RequestParam String code, @RequestParam double score) {
        return service.recordResult(studentId, code, score);
    }

    @GetMapping("/results")
    public List<Result> getAllResults() {
        return service.getResults();
    }
    @GetMapping("/results/student")
    public List<Result> getResultsByStudent(@RequestParam String studentId) {
        return service.getResultsByStudent(studentId);
    }
}

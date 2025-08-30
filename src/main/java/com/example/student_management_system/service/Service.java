package com.example.student_management_system.service;

import com.example.student_management_system.model.Course;
import com.example.student_management_system.model.Enrollment;
import com.example.student_management_system.model.Result;
import com.example.student_management_system.model.Student;
import com.example.student_management_system.repository.CourseRepository;
import com.example.student_management_system.repository.EnrollmentRepository;
import com.example.student_management_system.repository.ResultRepository;
import com.example.student_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private ResultRepository resultRepository;

    public List<Course> getAllCourses() {

        return courseRepository.findAll();
    }

    public Course createCourse(Course course) {

        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Course not found"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    public Enrollment enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(new Date());

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {

        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public Result recordResult(Long studentId, Long courseId, double score) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        Result result = new Result();
        result.setStudent(student);
        result.setCourse(course);
        result.setScore(score);
        result.setDateRecorded(new Date());

        return resultRepository.save(result);
    }

    public List<Result> getResultsByStudent(Long studentId) {

        return resultRepository.findByStudentId(studentId);
    }
}

package com.example.student_management_system.service;

import com.example.student_management_system.dto.CreateCourseDTO;
import com.example.student_management_system.dto.CreateStudentDTO;
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

    public Course createCourse(CreateCourseDTO course) {
        Course newCourse = new Course();
        newCourse.setTitle(course.getTitle());
        newCourse.setDescription(course.getDescription());
        newCourse.setCode(course.getCode());
        newCourse.setCredits(course.getCredits());

        return courseRepository.save(newCourse);
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

    public Student createStudent(CreateStudentDTO student) {
        Student newStudent = new Student();
        newStudent.setStudentId(student.getStudentId());
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        newStudent.setPhoneNumber(student.getPhoneNumber());
        return studentRepository.save(newStudent);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {

        studentRepository.deleteById(id);
    }

    public Enrollment enrollStudent(String studentId, String code) {
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(
                () -> new RuntimeException("Student not found"));
        Course course = courseRepository.findByCode(code).orElseThrow(
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

    public List<Enrollment> getEnrollmentsByStudent(String studentId) {
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        return enrollmentRepository.findByStudentId(student.getId());
    }

    public Result recordResult(String studentId, String code, double score) {
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Course not found"));

        Result result = new Result();
        result.setStudent(student);
        result.setCourse(course);
        result.setScore(score);
        result.setDateRecorded(new Date());

        return resultRepository.save(result);
    }

    public List<Result> getResultsByStudent(String studentId) {
        Student student = studentRepository.findByStudentId(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        return resultRepository.findByStudentId(student.getId());
    }

    public List<Result> getResults() {
        return resultRepository.findAll();
    }
}

package com.example.rest_services_for_an_education_site.Controllers;

import com.example.rest_services_for_an_education_site.Entity.Course;
import com.example.rest_services_for_an_education_site.Entity.Student;
import com.example.rest_services_for_an_education_site.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> registerStudent(@RequestBody @Validated Student student) {
        return ResponseEntity.ok(studentService.registerStudent(student));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(studentService.getCourses());
    }

    @PostMapping("/{studentId}/courses")
    public ResponseEntity<Student> allocateCourses(@PathVariable Long studentId, @RequestBody List<Long> courseIds) {
        return ResponseEntity.ok(studentService.allocateCourses(studentId, courseIds));
    }
    @GetMapping
    public ResponseEntity<List<Student>> getStudentsWithCourses() {
        return ResponseEntity.ok(studentService.getStudentsWithCourses());
    }

    @PutMapping("/{studentId}/courses")
    public ResponseEntity<Student> updateStudentCourses(@PathVariable Long studentId, @RequestBody List<Long> courseIds) {
        return ResponseEntity.ok(studentService.updateStudentCourses(studentId, courseIds));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}


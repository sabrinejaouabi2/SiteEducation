package com.example.rest_services_for_an_education_site.Services;

import com.example.rest_services_for_an_education_site.Entity.Course;
import com.example.rest_services_for_an_education_site.Entity.Student;
import com.example.rest_services_for_an_education_site.Repository.CourseRepository;
import com.example.rest_services_for_an_education_site.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Student allocateCourses(Long studentId, List<Long> courseIds) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        List<Course> courses = courseRepository.findAllById(courseIds);
        student.setCourses(courses);
        return studentRepository.save(student);
    }

    public List<Student> getStudentsWithCourses() {
        return studentRepository.findAll();
    }

    public Student updateStudentCourses(Long studentId, List<Long> courseIds) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        List<Course> courses = courseRepository.findAllById(courseIds);
        student.setCourses(courses);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


}

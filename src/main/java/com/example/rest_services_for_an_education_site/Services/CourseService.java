package com.example.rest_services_for_an_education_site.Services;

import com.example.rest_services_for_an_education_site.Entity.Course;
import com.example.rest_services_for_an_education_site.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setDurationInHours(course.getDurationInHours());
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new RuntimeException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }


}

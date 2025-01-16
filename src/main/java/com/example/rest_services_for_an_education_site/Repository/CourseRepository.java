package com.example.rest_services_for_an_education_site.Repository;

import com.example.rest_services_for_an_education_site.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
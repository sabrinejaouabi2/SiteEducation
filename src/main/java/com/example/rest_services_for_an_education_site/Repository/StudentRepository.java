package com.example.rest_services_for_an_education_site.Repository;

import com.example.rest_services_for_an_education_site.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}

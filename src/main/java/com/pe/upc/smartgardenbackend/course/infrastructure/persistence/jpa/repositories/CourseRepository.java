package com.pe.upc.smartgardenbackend.course.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsCourseByCourseCode(String courseCode);  // Método adicional para verificar si el curso existe por código.
}

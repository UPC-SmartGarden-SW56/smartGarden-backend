package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsCourseByCourseCode(String courseCode);
    List<Course> findByLevel(String level); // Buscar por nivel
}

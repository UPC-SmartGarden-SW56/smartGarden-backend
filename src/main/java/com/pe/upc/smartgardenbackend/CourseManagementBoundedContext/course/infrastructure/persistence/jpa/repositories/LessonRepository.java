package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    boolean existsLessonsByTitle(String title);
    List<Lesson> findByCourseId(Long courseId); // Buscar todas las lecciones de un curso
}

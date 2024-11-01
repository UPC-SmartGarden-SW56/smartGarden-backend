package com.pe.upc.smartgardenbackend.course.infrastructure.persistence.jpa.repositories;

import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    boolean existsLessonsByTitle(String title);

}

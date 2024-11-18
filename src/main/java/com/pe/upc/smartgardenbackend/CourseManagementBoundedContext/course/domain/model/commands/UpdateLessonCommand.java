package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonType;

public record UpdateLessonCommand(
        Long lessonId,
        String title,
        String description,
        LessonStatus status,  // Agregar si es necesario
        LessonType type,      // Agregar si es necesario
        String videoUrl,      // Nuevo campo
        Long courseId         // Nuevo campo
) {
    public UpdateLessonCommand {
        if (lessonId == null || lessonId <= 0) {
            throw new IllegalArgumentException("Lesson ID must be valid");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Lesson title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Lesson description cannot be null or blank");
        }
    }
}

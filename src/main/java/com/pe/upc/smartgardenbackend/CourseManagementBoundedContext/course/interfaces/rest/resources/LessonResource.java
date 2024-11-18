package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonType;

public record LessonResource(
        Long id,
        String title,
        String description,
        String videoUrl,  // Nuevo campo
        Long courseId,    // Nuevo campo
        LessonStatus status,
        LessonType type
) {
}

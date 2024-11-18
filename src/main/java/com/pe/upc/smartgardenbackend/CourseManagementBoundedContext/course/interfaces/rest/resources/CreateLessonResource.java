package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonType;

public record CreateLessonResource(
        Long lessonId,
        String title,
        String description,
        LessonStatus lessonStatus,
        LessonType lessonType,
        String videoUrl,  // Agregar este campo
        Long courseId     // Agregar este campo
) {
}

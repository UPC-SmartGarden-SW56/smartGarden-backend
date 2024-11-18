package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonType;

public record UpdateLessonResource(
        String title,
        String description,
        LessonStatus status,
        LessonType type,
        String videoUrl,
        Long courseId
) {
}

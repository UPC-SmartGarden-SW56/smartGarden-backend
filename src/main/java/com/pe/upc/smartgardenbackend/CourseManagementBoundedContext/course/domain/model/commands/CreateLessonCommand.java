package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonType;

public record CreateLessonCommand(
        String title,
        String description,
        LessonStatus status,
        LessonType type,
        String videoUrl,
        Long courseId
) {
    public CreateLessonCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Lesson title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Lesson description cannot be null or blank");
        }
        if (status == null) {
            throw new IllegalArgumentException("Lesson status cannot be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("Lesson type cannot be null");
        }
        if (courseId == null || courseId <= 0) {
            throw new IllegalArgumentException("Course ID must be valid");
        }
    }
}

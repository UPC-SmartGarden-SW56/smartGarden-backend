package com.pe.upc.smartgardenbackend.course.domain.model.commands;

import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonType;

public record CreateLessonCommand(Long id,String title, String description, LessonStatus status, LessonType type) {
    public CreateLessonCommand {
        if (id == null) {
            throw new IllegalArgumentException("lessonId cannot be null");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description cannot be null or blank");
        }
        if (status == null) {
            throw new IllegalArgumentException("status cannot be null");
        }
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
    }
}

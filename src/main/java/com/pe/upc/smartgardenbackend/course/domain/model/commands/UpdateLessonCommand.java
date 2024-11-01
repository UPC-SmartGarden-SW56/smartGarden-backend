package com.pe.upc.smartgardenbackend.course.domain.model.commands;

public record UpdateLessonCommand(String lessonId, String title, String description) {
    public UpdateLessonCommand {
        if (lessonId == null || lessonId.isBlank()) {
            throw new IllegalArgumentException("courseId cannot be null or less than 1");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description cannot be null or blank");
        }
    }
}

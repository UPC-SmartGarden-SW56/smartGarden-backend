package com.pe.upc.smartgardenbackend.course.domain.exceptions;

public class LessonNotFoundException extends RuntimeException {
    public LessonNotFoundException(String lessonId) {
        super("Lesson with id " + lessonId + " not found");
    }
}

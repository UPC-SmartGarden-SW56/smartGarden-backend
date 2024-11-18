package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.exceptions;

public class LessonNotFoundException extends RuntimeException {
    public LessonNotFoundException(String lessonId) {
        super("Lesson with id " + lessonId + " not found");
    }
}

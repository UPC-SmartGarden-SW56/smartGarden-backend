package com.pe.upc.smartgardenbackend.course.domain.model.valueobjects;

import jakarta.persistence.Embeddable;



@Embeddable
public record LessonRecordId() {
    private static long id;
    public LessonRecordId {

        if (id <= 0) {
            throw new IllegalArgumentException("Lesson lessonId cannot be empty");
        }
    }
    public long getId() {
        return id;
    }

}

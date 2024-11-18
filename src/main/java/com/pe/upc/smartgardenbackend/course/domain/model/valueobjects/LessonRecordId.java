package com.pe.upc.smartgardenbackend.course.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class LessonRecordId {
    @Column(name = "lesson_id")
    private long id;

    // Constructor que acepta un ID
    public LessonRecordId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Lesson lessonId cannot be empty");
        }
        this.id = id;
    }

    // Constructor vacío para JPA
    public LessonRecordId() {}

}

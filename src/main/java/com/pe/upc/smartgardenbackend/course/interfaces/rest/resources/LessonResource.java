package com.pe.upc.smartgardenbackend.course.interfaces.rest.resources;

import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Lesson;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonRecordId;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonType;

public record LessonResource(Long id, String title, String description) {
}

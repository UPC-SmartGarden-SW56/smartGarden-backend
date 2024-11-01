package com.pe.upc.smartgardenbackend.course.interfaces.rest.resources;

import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonType;

public record CreateLessonResource(Long lessonId, String title, String description, LessonStatus lessonStatus, LessonType lessonType) {

}

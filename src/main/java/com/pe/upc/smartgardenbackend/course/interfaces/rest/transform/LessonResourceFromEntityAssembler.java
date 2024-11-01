package com.pe.upc.smartgardenbackend.course.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Lesson;
import com.pe.upc.smartgardenbackend.course.interfaces.rest.resources.LessonResource;

public class LessonResourceFromEntityAssembler {
    public static LessonResource toResourceFromEntity(Lesson entity) {
        return new LessonResource(entity.getLessonId(),entity.getTitle(),entity.getDescription());
    }
}

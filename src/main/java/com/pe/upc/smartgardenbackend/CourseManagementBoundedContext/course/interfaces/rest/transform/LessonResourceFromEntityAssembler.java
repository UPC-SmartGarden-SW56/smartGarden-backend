package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Lesson;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources.LessonResource;

public class LessonResourceFromEntityAssembler {
    public static LessonResource toResourceFromEntity(Lesson entity) {
        return new LessonResource(
                entity.getLessonId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getVideoUrl(),       // Asignamos el campo videoUrl
                entity.getCourse().getId(), // Obtenemos el ID del curso asociado
                entity.getStatus(),
                entity.getType()
        );
    }
}

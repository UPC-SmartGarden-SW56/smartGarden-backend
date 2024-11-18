package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources.CreateLessonResource;

public class CreateLessonCommandFromResourceAssembler {
    public static CreateLessonCommand toCommandFromResource(CreateLessonResource resource) {
        return new CreateLessonCommand(
                resource.title(),         // Título de la lección
                resource.description(),   // Descripción de la lección
                resource.lessonStatus(),  // Estado de la lección
                resource.lessonType(),    // Tipo de la lección
                resource.videoUrl(),      // URL del video
                resource.courseId()       // ID del curso
        );
    }
}

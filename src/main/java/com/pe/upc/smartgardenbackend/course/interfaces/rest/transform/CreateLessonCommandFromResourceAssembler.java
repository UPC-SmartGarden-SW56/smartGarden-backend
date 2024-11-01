package com.pe.upc.smartgardenbackend.course.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.course.interfaces.rest.resources.CreateLessonResource;

public class CreateLessonCommandFromResourceAssembler {
    public static CreateLessonCommand toCommandFromResource(CreateLessonResource resource) {
        return new CreateLessonCommand( resource.lessonId(), resource.title(), resource.description(), resource.lessonStatus(), resource.lessonType() );
    }
}

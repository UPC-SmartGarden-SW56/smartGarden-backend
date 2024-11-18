package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.UpdateLessonCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources.UpdateLessonResource;

public class UpdateLessonCommandFromResourceAssembler {
    public static UpdateLessonCommand toCommandFromResource(Long lessonId, UpdateLessonResource resource) {
        return new UpdateLessonCommand(
                lessonId,
                resource.title(),
                resource.description(),
                resource.status(),
                resource.type(),
                resource.videoUrl(),
                resource.courseId()
        );
    }
}

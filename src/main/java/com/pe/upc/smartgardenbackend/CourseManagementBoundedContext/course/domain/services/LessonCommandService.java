package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.services;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.UpdateLessonCommand;

public interface LessonCommandService {

    Long handle(CreateLessonCommand command);

    Long handle (UpdateLessonCommand command);
}

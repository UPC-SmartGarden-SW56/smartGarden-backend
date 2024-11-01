package com.pe.upc.smartgardenbackend.course.domain.services;

import com.pe.upc.smartgardenbackend.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.course.domain.model.commands.UpdateLessonCommand;

public interface LessonCommandService {

    Long handle(CreateLessonCommand command);

    Long handle (UpdateLessonCommand command);
}

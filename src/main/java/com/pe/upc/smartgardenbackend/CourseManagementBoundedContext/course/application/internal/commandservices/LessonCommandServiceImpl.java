package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.application.internal.commandservices;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Course;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Lesson;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.UpdateLessonCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.services.LessonCommandService;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.infrastructure.persistence.jpa.repositories.CourseRepository;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.infrastructure.persistence.jpa.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonCommandServiceImpl implements LessonCommandService {
    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    public LessonCommandServiceImpl(LessonRepository lessonRepository, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Long handle(CreateLessonCommand command) {
        // Crear una nueva lección
        Lesson lesson = new Lesson();
        lesson.setTitle(command.title());
        lesson.setDescription(command.description());
        lesson.setType(command.type());
        lesson.setStatus(command.status());
        lesson.setVideoUrl(command.videoUrl()); // Asegúrate de que este método exista en la entidad Lesson

        // Buscar el curso relacionado
        Course course = courseRepository.findById(command.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));
        lesson.setCourse(course);

        // Guardar la lección
        lessonRepository.save(lesson);
        return lesson.getId();
    }

    @Override
    public Long handle(UpdateLessonCommand command) {
        var existingLesson = lessonRepository.findById(command.lessonId())
                .orElseThrow(() -> new IllegalArgumentException("Lesson not found"));

        existingLesson.setTitle(command.title());
        existingLesson.setDescription(command.description());
        existingLesson.setStatus(command.status());
        existingLesson.setType(command.type());
        existingLesson.setVideoUrl(command.videoUrl());

        // Si el curso también se puede actualizar:
        if (command.courseId() != null) {
            var course = courseRepository.findById(command.courseId())
                    .orElseThrow(() -> new IllegalArgumentException("Course not found"));
            existingLesson.setCourse(course);
        }

        lessonRepository.save(existingLesson);
        return existingLesson.getLessonId();
    }
}


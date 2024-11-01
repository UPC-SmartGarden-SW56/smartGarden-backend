package com.pe.upc.smartgardenbackend.course.application.internal.commandservices;

import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Lesson;
import com.pe.upc.smartgardenbackend.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.course.domain.model.commands.UpdateLessonCommand;
import com.pe.upc.smartgardenbackend.course.domain.services.LessonCommandService;
import com.pe.upc.smartgardenbackend.course.infrastructure.persistence.jpa.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonCommandServiceImpl implements LessonCommandService {
    private LessonRepository lessonRepository;
    public LessonCommandServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public Long handle(CreateLessonCommand command) {
        var lesson = new Lesson(command);
        try {
            lessonRepository.save(lesson);
        }catch (Exception e) {
            throw new IllegalArgumentException("Error while saving lesson" + e.getMessage());
        }
        return lesson.getId();
    }


    @Override
    public Long handle(UpdateLessonCommand command) {
        if (lessonRepository.existsLessonsByTitle(command.title()))
            throw new IllegalArgumentException("Lesson title already exists".formatted(command.title()));
        var result = lessonRepository.findById(Long.valueOf(command.lessonId()));
        if (result.isEmpty())
            throw new IllegalArgumentException("Lesson does not exist".formatted(command.lessonId()));
        var lessonToUpdate = result.get();
        try {
            var updatedLesson = lessonRepository.save(lessonToUpdate.updateInformation(command.title(), command.description()));
            return Optional.of(updatedLesson.getId()).get();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving lesson" + e.getMessage());
        }

    }

}

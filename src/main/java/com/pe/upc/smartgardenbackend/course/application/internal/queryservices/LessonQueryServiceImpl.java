package com.pe.upc.smartgardenbackend.course.application.internal.queryservices;

import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Lesson;
import com.pe.upc.smartgardenbackend.course.domain.model.queries.GetAllLessonsQuery;
import com.pe.upc.smartgardenbackend.course.domain.model.queries.GetLessonByIdQuery;
import com.pe.upc.smartgardenbackend.course.domain.services.LessonQueryService;
import com.pe.upc.smartgardenbackend.course.infrastructure.persistence.jpa.repositories.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonQueryServiceImpl implements LessonQueryService {
    private final LessonRepository lessonRepository;
    public LessonQueryServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
    @Override
    public Optional<Lesson>handle(GetLessonByIdQuery query) {
        return lessonRepository.findById(Long.valueOf(query.lessonId()));
    }

    @Override
    public List<Lesson> handle(GetAllLessonsQuery query) {
        return lessonRepository.findAll();
    }
}

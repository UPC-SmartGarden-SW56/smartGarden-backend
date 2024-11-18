package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.services;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Lesson;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.queries.GetAllLessonsQuery;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.queries.GetLessonByIdQuery;

import java.util.List;
import java.util.Optional;

public interface LessonQueryService {
    Optional<Lesson> handle(GetLessonByIdQuery query);
    List<Lesson> handle(GetAllLessonsQuery query);
}

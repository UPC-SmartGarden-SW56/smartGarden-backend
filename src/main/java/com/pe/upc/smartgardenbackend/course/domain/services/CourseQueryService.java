package com.pe.upc.smartgardenbackend.course.domain.services;

import com.pe.upc.smartgardenbackend.course.domain.model.queries.GetAllCoursesQuery;
import com.pe.upc.smartgardenbackend.course.domain.model.queries.GetCourseByIdQuery;
import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Course;

import java.util.List;
import java.util.Optional;

public interface CourseQueryService {

    Optional<Course> handle(GetCourseByIdQuery query);

    List<Course> handle(GetAllCoursesQuery query);
}

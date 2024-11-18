package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.application.internal.queryservices;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Course;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.queries.GetAllCoursesQuery;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.queries.GetCourseByIdQuery;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.services.CourseQueryService;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.infrastructure.persistence.jpa.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseQueryServiceImpl implements CourseQueryService {

    private final CourseRepository courseRepository;

    public CourseQueryServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Optional<Course> handle(GetCourseByIdQuery query) {
        return courseRepository.findById(query.courseId());
    }

    @Override
    public List<Course> handle(GetAllCoursesQuery query) {
        return courseRepository.findAll();
    }
}

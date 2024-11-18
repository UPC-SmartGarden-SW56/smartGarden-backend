package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.application.internal.commandservices;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.CreateCourseCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Course;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.infrastructure.persistence.jpa.repositories.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseCommandServiceImpl {

    private final CourseRepository courseRepository;

    public CourseCommandServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Long handle(CreateCourseCommand command) {
        if (courseRepository.existsCourseByCourseCode(command.courseCode())) {
            throw new IllegalArgumentException("Course with the same course code already exists");
        }

        Course course = new Course();
        course.setTitle(command.title());
        course.setDescription(command.description());
        course.setCourseCode(command.courseCode());
        course.setImageUrl(command.imageUrl());
        course.setDurationHours(command.durationHours());
        course.setPrice(command.price());
        course.setLevel(command.level());

        courseRepository.save(course);
        return course.getId();
    }

}

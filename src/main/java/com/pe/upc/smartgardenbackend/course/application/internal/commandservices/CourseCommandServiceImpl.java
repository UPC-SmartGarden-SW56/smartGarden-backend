package com.pe.upc.smartgardenbackend.course.application.internal.commandservices;

import com.pe.upc.smartgardenbackend.course.domain.model.commands.CreateCourseCommand;
import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Course;
import com.pe.upc.smartgardenbackend.course.infrastructure.persistence.jpa.repositories.CourseRepository;
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

        Course course = new Course(command.title(), command.description(), command.courseCode());
        courseRepository.save(course);
        return course.getId();
    }
}

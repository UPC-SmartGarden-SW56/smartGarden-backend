package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Course;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources.CourseResource;

public class CourseResourceFromEntityAssembler {

    public static CourseResource toResourceFromEntity(Course course) {
        return new CourseResource(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getCourseCode(),
                course.getImageUrl(),
                course.getDurationHours(),
                course.getPrice(),
                course.getLevel()
        );
    }

}

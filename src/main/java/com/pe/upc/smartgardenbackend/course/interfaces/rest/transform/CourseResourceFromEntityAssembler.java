package com.pe.upc.smartgardenbackend.course.interfaces.rest.transform;

import com.pe.upc.smartgardenbackend.course.domain.model.aggregates.Course;
import com.pe.upc.smartgardenbackend.course.interfaces.rest.resources.CourseResource;

public class CourseResourceFromEntityAssembler {

    public static CourseResource toResourceFromEntity(Course course) {  // Cambiado Long course a Course
        return new CourseResource(
                course.getId(),               // Obtén el ID desde el objeto Course
                course.getTitle(),            // Obtén el título del curso
                course.getDescription(),      // Obtén la descripción del curso
                course.getCourseCode()        // Obtén el código del curso
        );
    }
}

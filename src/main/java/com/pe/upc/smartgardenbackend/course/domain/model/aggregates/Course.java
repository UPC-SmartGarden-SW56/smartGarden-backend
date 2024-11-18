package com.pe.upc.smartgardenbackend.course.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.course.domain.model.commands.CreateCourseCommand;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter  // Lombok generará automáticamente los getters
@Setter  // Lombok generará automáticamente los setters
public class Course extends AuditableAbstractAggregateRoot<Course> {

    private String title;
    private String description;

    @Column(name = "course_code", unique = true)
    private String courseCode;  // Añadimos un campo único para identificar el curso.

    // Constructor vacío para JPA
    public Course() {
        super();
    }

    // Constructor con parámetros
    public Course(String title, String description, String courseCode) {
        this.title = title;
        this.description = description;
        this.courseCode = courseCode;
    }

    public Course updateInformation(CreateCourseCommand updateCourseCommand) {
        this.title = updateCourseCommand.title();
        this.description = updateCourseCommand.description();
        this.courseCode = updateCourseCommand.courseCode();  // Accede al campo 'courseCode' del record
        // Actualiza otros campos según sea necesario
        return this;
    }
}
package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.CreateCourseCommand;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter  // Lombok generará automáticamente los getters
@Setter  // Lombok generará automáticamente los setters
public class Course extends AuditableAbstractAggregateRoot<Course> {


    @Column(nullable = false)
    @Getter
    @Setter
    private String title;

    @Column(nullable = false, length = 500)
    @Getter
    @Setter
    private String description;

    @Column(name = "course_code", nullable = false, unique = true)
    @Getter
    @Setter
    private String courseCode;

    @Column(name = "image_url", length = 500)
    @Getter
    @Setter
    private String imageUrl; // Asegúrate de que esté en el JSON

    @Column(name = "duration_hours")
    @Getter
    @Setter
    private Integer durationHours; // Campo adicional

    @Column(nullable = false)
    @Getter
    @Setter
    private Double price; // Agregar si está en JSON

    @Column(name = "level", nullable = false)
    @Getter
    @Setter
    private String level; // Por ejemplo: beginner, intermediate, advanced

    // Constructor vacío para JPA
    public Course() {
        super();
    }

    // Constructor con parámetros
    public Course(String title, String description, String courseCode,String imageUrl, Integer durationHours, Double price, String level) {
        this.title = title;
        this.description = description;
        this.courseCode = courseCode;
        this.imageUrl = null;
        this.durationHours = null;
        this.price = null;
        this.level = null;
    }


    public Course updateInformation(CreateCourseCommand updateCourseCommand) {
        this.title = updateCourseCommand.title();
        this.description = updateCourseCommand.description();
        this.courseCode = updateCourseCommand.courseCode();  // Accede al campo 'courseCode' del record
        // Actualiza otros campos según sea necesario
        return this;
    }
    // Relación con lecciones
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesson> lessons = new ArrayList<>();
}
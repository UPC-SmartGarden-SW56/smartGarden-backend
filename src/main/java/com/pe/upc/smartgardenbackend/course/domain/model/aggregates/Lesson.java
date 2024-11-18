package com.pe.upc.smartgardenbackend.course.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonRecordId;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonType;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Entity
public class Lesson extends AuditableAbstractAggregateRoot<Lesson> {


    @Embedded
    private LessonRecordId lessonRecordId;

    @Enumerated(EnumType.STRING)  // Esto guardará los valores como cadenas
    private LessonType type;

    @Enumerated(EnumType.STRING)  // Lo mismo para status
    private LessonStatus status;

    @Getter
    private String title;
    @Getter
    private String description;

    // Constructor vacío para JPA
    public Lesson() {
        super();
        // Generamos un ID válido, por ejemplo, usando el tiempo actual
        this.lessonRecordId = new LessonRecordId(System.currentTimeMillis()); // Asignamos un valor válido al id
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
        this.type = LessonType.THEORY;
        this.status = LessonStatus.PUBLISHED;
    }


    // Constructor con parámetros
    public Lesson(String title, String description, LessonRecordId lessonRecordId, LessonType type, LessonStatus status) {
        this.title = title;
        this.description = description;
        this.lessonRecordId = lessonRecordId;
        this.type = type;
        this.status = status;
    }


    //create with given title and description
    public Lesson updateInformation(String title, String description) {
        this.title = title;
        this.description = description;
        //this.type = type;
        //this.status = status;
        return this;
    }

    public Lesson(CreateLessonCommand command){
        this.lessonRecordId = new LessonRecordId(); // Aquí también inicializamos el lessonId de manera válida
        this.title = command.title();
        this.description = command.description();
        this.type = command.type();
        this.status = command.status();
    }

    //si no es string es long
    public Long getLessonId() {
        return this.lessonRecordId.getId();
    }

}

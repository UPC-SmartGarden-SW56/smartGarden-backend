package com.pe.upc.smartgardenbackend.course.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonRecordId;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.course.domain.model.valueobjects.LessonType;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

@Getter
@Entity
public class Lesson extends AuditableAbstractAggregateRoot<Lesson> {

    private String title;
    private String description;

    @Getter
    @Embedded
    @Column(name = "lesson_id")
    private LessonRecordId lessonRecordId;

    @Embedded
    private LessonType type;
    private LessonStatus status;

    //create new course
    public Lesson() {
        super();
        this.lessonRecordId = new LessonRecordId();
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
        this.type=LessonType.THEORY;
        this.status=LessonStatus.PUBLISHED;
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
        this.lessonRecordId=new LessonRecordId();
        this.title= command.title();
        this.description = command.description();
        this.type=command.type();
        this.status=command.status();
    }

    //si no es string es long
    public Long getLessonId() {
        return this.lessonRecordId.getId();
    }

}

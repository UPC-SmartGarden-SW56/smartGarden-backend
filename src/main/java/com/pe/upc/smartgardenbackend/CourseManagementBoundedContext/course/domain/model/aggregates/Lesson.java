package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.CreateLessonCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonRecordId;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonStatus;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.valueobjects.LessonType;
import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

@Entity
@Getter
@Setter
public class Lesson extends AuditableAbstractAggregateRoot<Lesson> {

    @Embedded
    @Getter
    @Setter
    private LessonRecordId lessonRecordId;

    @Column(nullable = false)
    @Getter
    @Setter
    private String title;

    @Column(nullable = false, length = 500)
    @Getter
    @Setter
    private String description;

    @Column(name = "video_url", length = 500)
    @Getter
    @Setter
    private String videoUrl;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private LessonType type;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private LessonStatus status;

    @ManyToOne
    @Getter
    @Setter
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Constructor vacío para JPA
    public Lesson() {
        this.lessonRecordId = new LessonRecordId(System.currentTimeMillis());
        this.title = Strings.EMPTY;
        this.description = Strings.EMPTY;
        this.type = LessonType.THEORY;
        this.status = LessonStatus.PUBLISHED;
    }

    // Constructor con parámetros
    public Lesson(CreateLessonCommand command) {
        this.lessonRecordId = new LessonRecordId(System.currentTimeMillis());
        this.title = command.title();
        this.description = command.description();
        this.type = command.type();
        this.status = command.status();
        this.videoUrl = command.videoUrl();
    }

    public Lesson updateInformation(String title, String description) {
        this.title = title;
        this.description = description;
        return this;
    }

    public Long getLessonId() {
        return this.lessonRecordId.getId();
    }
}

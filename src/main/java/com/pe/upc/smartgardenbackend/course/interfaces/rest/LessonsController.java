package com.pe.upc.smartgardenbackend.course.interfaces.rest;

import com.pe.upc.smartgardenbackend.course.domain.model.queries.GetLessonByIdQuery;
import com.pe.upc.smartgardenbackend.course.domain.services.LessonCommandService;
import com.pe.upc.smartgardenbackend.course.domain.services.LessonQueryService;
import com.pe.upc.smartgardenbackend.course.interfaces.rest.resources.CreateLessonResource;
import com.pe.upc.smartgardenbackend.course.interfaces.rest.resources.LessonResource;
import com.pe.upc.smartgardenbackend.course.interfaces.rest.transform.CreateLessonCommandFromResourceAssembler;
import com.pe.upc.smartgardenbackend.course.interfaces.rest.transform.LessonResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/lessons", produces = APPLICATION_JSON_VALUE)
@Tag(name="Lessons", description = "Lesson Management Endpoints")
public class LessonsController {
    private final LessonCommandService lessonCommandService;
    private final LessonQueryService lessonQueryService;

    public LessonsController(LessonCommandService lessonCommandService, LessonQueryService lessonQueryService) {
        this.lessonCommandService = lessonCommandService;
        this.lessonQueryService = lessonQueryService;
    }

    @PostMapping
    public ResponseEntity<LessonResource> createLesson(@RequestBody CreateLessonResource createLessonResource) {
        var createLessonCommand = CreateLessonCommandFromResourceAssembler.toCommandFromResource(createLessonResource);
        var lessonId = lessonCommandService.handle(createLessonCommand);
        if(lessonId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getLessonsByIdQuery = new GetLessonByIdQuery(lessonId);
        var lesson = lessonQueryService.handle(getLessonsByIdQuery);
        if(lesson.isEmpty())return ResponseEntity.badRequest().build();
        var lessonResource = LessonResourceFromEntityAssembler.toResourceFromEntity(lesson.get());
        return new ResponseEntity<>(lessonResource, HttpStatus.CREATED);


    }
}

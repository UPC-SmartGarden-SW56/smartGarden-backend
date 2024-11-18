package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.UpdateLessonCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.queries.GetAllLessonsQuery;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.queries.GetLessonByIdQuery;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.services.LessonCommandService;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.services.LessonQueryService;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.infrastructure.persistence.jpa.repositories.LessonRepository;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources.CreateLessonResource;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources.LessonResource;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources.UpdateLessonResource;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.transform.CreateLessonCommandFromResourceAssembler;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.transform.LessonResourceFromEntityAssembler;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.transform.UpdateLessonCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/lessons", produces = APPLICATION_JSON_VALUE)
@Tag(name="Lessons", description = "Lesson Management Endpoints")
public class LessonsController {
    private final LessonRepository lessonRepository;
    private final LessonCommandService lessonCommandService;
    private final LessonQueryService lessonQueryService;

    public LessonsController(LessonRepository lessonRepository, LessonCommandService lessonCommandService, LessonQueryService lessonQueryService) {
        this.lessonRepository = lessonRepository;
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

    // Método para obtener todas las lecciones
    @GetMapping
    public ResponseEntity<List<LessonResource>> getAllLessons() {
        var lessons = lessonQueryService.handle(new GetAllLessonsQuery());

        // Convertimos las lecciones a LessonResource
        var lessonResources = lessons.stream()
                .map(LessonResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lessonResources);
    }

    // Método para obtener una lección por su ID
    @GetMapping("/{id}")
    public ResponseEntity<LessonResource> getLessonById(@PathVariable Long id) {
        var query = new GetLessonByIdQuery(id);
        var lesson = lessonQueryService.handle(query);

        if (lesson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        var lessonResource = LessonResourceFromEntityAssembler.toResourceFromEntity(lesson.get());
        return ResponseEntity.ok(lessonResource);
    }

    // Método DELETE para eliminar una lección por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        var query = new GetLessonByIdQuery(id);
        var lesson = lessonQueryService.handle(query);

        if (lesson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // Si la lección existe, procedemos a eliminarla directamente desde el repositorio
        lessonRepository.deleteById(id); // Usamos el repositorio para eliminar
        return ResponseEntity.noContent().build();
    }

    // Método PUT para actualizar una lección por su ID
    @PutMapping("/{id}")
    public ResponseEntity<LessonResource> updateLesson(
            @PathVariable Long id,
            @RequestBody UpdateLessonResource updateLessonResource
    ) {
        try {
            var updateLessonCommand = UpdateLessonCommandFromResourceAssembler.toCommandFromResource(id, updateLessonResource);
            lessonCommandService.handle(updateLessonCommand);

            var updatedLesson = lessonQueryService.handle(new GetLessonByIdQuery(id));

            if (updatedLesson.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            var lessonResource = LessonResourceFromEntityAssembler.toResourceFromEntity(updatedLesson.get());
            return ResponseEntity.ok(lessonResource);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}

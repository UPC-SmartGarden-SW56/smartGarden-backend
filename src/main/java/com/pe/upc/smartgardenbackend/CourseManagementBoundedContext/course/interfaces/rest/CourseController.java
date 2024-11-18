package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest;

import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.application.internal.commandservices.CourseCommandServiceImpl;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.aggregates.Course;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands.CreateCourseCommand;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.infrastructure.persistence.jpa.repositories.CourseRepository;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources.CourseResource;
import com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.transform.CourseResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/courses")
@Tag(name = "Courses", description = "Courses management endpoints")
public class CourseController {

    private final CourseCommandServiceImpl courseCommandService;
    private final CourseRepository courseRepository; // Inyectamos el repositorio de Course

    public CourseController(CourseCommandServiceImpl courseCommandService, CourseRepository courseRepository) {
        this.courseCommandService = courseCommandService;
        this.courseRepository = courseRepository;
    }

    // Método para crear un nuevo curso
    @PostMapping
    public ResponseEntity<CourseResource> createCourse(@RequestBody CreateCourseCommand createCourseCommand) {
        try {
            Long courseId = courseCommandService.handle(createCourseCommand); // Obtén el ID del curso
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new IllegalArgumentException("Course not found"));

            var courseResource = CourseResourceFromEntityAssembler.toResourceFromEntity(course); // Pasamos el curso a recurso

            return new ResponseEntity<>(courseResource, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Método GET para obtener un curso por su ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseResource> getCourseById(@PathVariable Long id) {
        try {
            Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));

            var courseResource = CourseResourceFromEntityAssembler.toResourceFromEntity(course); // Pasamos el curso a recurso

            return new ResponseEntity<>(courseResource, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Si el curso no se encuentra, responde con un 404
        }
    }

    // Método GET para obtener todos los cursos
    @GetMapping
    public ResponseEntity<List<CourseResource>> getAllCourses() {
        try {
            List<Course> courses = courseRepository.findAll(); // Obtenemos todos los cursos

            // Convertimos la lista de cursos en una lista de recursos
            List<CourseResource> courseResources = courses.stream()
                    .map(CourseResourceFromEntityAssembler::toResourceFromEntity)
                    .collect(Collectors.toList());

            return new ResponseEntity<>(courseResources, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Responde con un error en caso de problemas
        }
    }

    // Método DELETE para eliminar un curso por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        try {
            Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));

            // Eliminamos el curso
            courseRepository.delete(course);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Responde con 204 si se eliminó correctamente
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Si no se encuentra el curso, responde con 404
        }
    }

    // Método PUT para actualizar un curso por su ID
    @PutMapping("/{id}")
    public ResponseEntity<CourseResource> updateCourse(@PathVariable Long id, @RequestBody CreateCourseCommand updateCourseCommand) {
        try {
            Course course = courseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Course not found"));

            // Actualizamos el curso con los nuevos datos
            course.updateInformation(updateCourseCommand); // Asegúrate de tener este método de actualización en la entidad Course

            // Guardamos los cambios
            courseRepository.save(course);

            var courseResource = CourseResourceFromEntityAssembler.toResourceFromEntity(course); // Convertimos el curso a recurso
            return new ResponseEntity<>(courseResource, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Si no se encuentra el curso, responde con 404
        }
    }
}

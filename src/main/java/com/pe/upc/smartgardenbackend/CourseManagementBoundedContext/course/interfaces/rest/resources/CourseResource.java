package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.interfaces.rest.resources;

public record CourseResource(Long id, String title, String description, String courseCode,
                             String imageUrl, Integer durationHours, Double price, String level) {
}

package com.pe.upc.smartgardenbackend.CourseManagementBoundedContext.course.domain.model.commands;

public record CreateCourseCommand(String title, String description, String courseCode,String imageUrl, Integer durationHours, Double price, String level ) {
    public CreateCourseCommand {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Course title cannot be null or blank");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("Course description cannot be null or blank");
        }
        if (courseCode == null || courseCode.isBlank()) {
            throw new IllegalArgumentException("Course code cannot be null or blank");
        }
        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("Image URL cannot be null or blank");
        }

    }
}

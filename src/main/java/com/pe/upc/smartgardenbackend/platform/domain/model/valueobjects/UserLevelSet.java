package com.pe.upc.smartgardenbackend.platform.domain.model.valueobjects;

import jakarta.persistence.Embeddable;


/**
 * Value object representing the user level metric set.
 * @summary
 * This value object is used to represent the user experience level metric set. It is an embeddable object that is used to represent the user performance metric set in the student record entity.
 * It throws an IllegalArgumentException if the total completed courses or total consecutive streaks are null or less than 0.
 * @param totalCompletedCourses The total number of completed courses. It cannot be null or less than 0.
 * @param totalEngagementPoints The total number of consecutive streaks. It cannot be null or less than 0.
 * @see IllegalArgumentException
 * @since 1.0
 */

@Embeddable
public record UserLevelSet(Integer totalCompletedCourses,
                           Integer totalEngagementPoints) {
    public UserLevelSet(){
        this(0, 0);
    }
    public UserLevelSet {
        if(totalCompletedCourses == null || totalCompletedCourses < 0)
            throw new IllegalArgumentException("total completed courses cannot be null or less than 0");
        if (totalEngagementPoints == null || totalEngagementPoints < 0)
            throw new IllegalArgumentException("total engagement points cannot be null or less than 0");
    }

    /**
     * Increments the total number of completed courses by 1.
     * @summary
     * This method is used to increment the total number of completed courses by 1.
     * @return A new instance of the UserLevelSet value object with the total number of completed courses incremented by 1.
     * @since 1.0
     */

    public UserLevelSet incrementTotalCompletedCourses() {
        return new UserLevelSet(totalCompletedCourses + 1, totalEngagementPoints);
    }

    /**
     * Increments the total number of consecutive streaks by 1.
     * @summary
     * This method is used to increment the total number of consecutive streaks by 1.
     * @return A new instance of the UserLevelSet value object with the total number of consecutive streaks incremented by 1.
     * @since 1.0
     */

    public UserLevelSet incrementTotalEngagementPoints() {
        return new UserLevelSet(totalCompletedCourses, totalEngagementPoints + 1);
    }

}

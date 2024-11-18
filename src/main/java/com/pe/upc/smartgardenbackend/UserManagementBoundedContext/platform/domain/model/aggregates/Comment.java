package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment extends AuditableAbstractAggregateRoot<Comment> {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long publicationId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @Column(name = "parent_comment_id")
    private Long parentCommentId;

    @Column(name = "number_likes", nullable = false)
    private Integer numberLikes;

    @Column(name = "number_responses", nullable = false)
    private Integer numberResponses;
}

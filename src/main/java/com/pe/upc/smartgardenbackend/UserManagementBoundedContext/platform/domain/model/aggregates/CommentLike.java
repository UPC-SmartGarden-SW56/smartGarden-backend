package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "comment_likes")
public class CommentLike extends AuditableAbstractAggregateRoot<CommentLike> {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long commentId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;
}

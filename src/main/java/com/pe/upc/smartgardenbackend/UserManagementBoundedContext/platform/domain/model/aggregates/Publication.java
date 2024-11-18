package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "publications")
public class Publication extends AuditableAbstractAggregateRoot<Publication> {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long communityId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    private String imageUrl;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;

    @Column(name = "is_pinned", nullable = false)
    private Boolean isPinned;

    @Column(name = "number_likes", nullable = false)
    private Integer numberLikes;

    @Column(name = "number_comments", nullable = false)
    private Integer numberComments;
}

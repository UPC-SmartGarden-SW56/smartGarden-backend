package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "publication_likes")
public class PublicationLike extends AuditableAbstractAggregateRoot<PublicationLike> {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long publicationId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;
}

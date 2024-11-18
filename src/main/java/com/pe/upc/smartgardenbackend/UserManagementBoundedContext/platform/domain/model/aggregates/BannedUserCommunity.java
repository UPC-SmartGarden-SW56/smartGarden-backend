package com.pe.upc.smartgardenbackend.UserManagementBoundedContext.platform.domain.model.aggregates;

import com.pe.upc.smartgardenbackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "banned_user_community")
public class BannedUserCommunity extends AuditableAbstractAggregateRoot<BannedUserCommunity> {

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long communityId;

    private String note;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "banned_date", nullable = false)
    private Date bannedDate;
}

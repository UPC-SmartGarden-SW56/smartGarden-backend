package com.pe.upc.smartgardenbackend.platform.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record ExpertRecordId(String expertRecordId) {
    public ExpertRecordId() {
        this(UUID.randomUUID().toString());
    }
    public ExpertRecordId {
        if (expertRecordId == null ||  expertRecordId.isBlank()){
            throw new IllegalArgumentException("expert record Id cannot be null or empty");
        }
    }
}

package com.raulvalesc.favslistsapi.shared.infrastructure.persistance.hibernate;

import jakarta.persistence.MappedSuperclass;

import java.time.Instant;

@MappedSuperclass
public class AggregateRootEntity {
    protected Instant createdAt;

    protected Instant deletedAt;

    protected Boolean isDeleted;

    protected Instant updatedAt;

    protected AggregateRootEntity() {}

    protected AggregateRootEntity(Instant createdAt, Instant deletedAt, Boolean isDeleted, Instant updatedAt) {
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.isDeleted = isDeleted;
        this.updatedAt = updatedAt;
    }
}

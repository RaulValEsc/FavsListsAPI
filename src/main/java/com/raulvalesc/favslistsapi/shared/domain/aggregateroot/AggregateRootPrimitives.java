package com.raulvalesc.favslistsapi.shared.domain.aggregateroot;

import java.time.Instant;

public abstract class AggregateRootPrimitives {
    private Instant createdAt;

    private Instant deletedAt;

    private Boolean isDeleted;

    private Instant updatedAt;

    public AggregateRootPrimitives(Instant createdAt, Instant deletedAt, Boolean isDeleted, Instant updatedAt) {
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.isDeleted = isDeleted;
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}

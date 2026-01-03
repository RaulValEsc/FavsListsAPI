package com.raulvalesc.favslistsapi.shared.domain.entity;

public abstract class Entity<Primitives extends EntityPrimitives> {
    public final EntityCreatedAt createdAt;
    public final EntityDeletedAt deletedAt;
    public final EntityIsDeleted isDeleted;
    public EntityUpdatedAt updatedAt;

    protected Entity(EntityCreatedAt createdAt, EntityDeletedAt deletedAt, EntityIsDeleted isDeleted, EntityUpdatedAt updatedAt) {
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.isDeleted = isDeleted;
        this.updatedAt = updatedAt;
    }

    public abstract Primitives toPrimitives();
}

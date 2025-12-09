package com.raulvalesc.favslistsapi.shared.domain.aggregateroot;

public abstract class AggregateRoot<Primitives extends AggregateRootPrimitives> {
    public final AggregateRootCreatedAt createdAt;

    public final AggregateRootDeletedAt deletedAt;

    public final AggregateRootIsDeleted isDeleted;

    public AggregateRootUpdatedAt updatedAt;

    protected AggregateRoot(AggregateRootCreatedAt createdAt, AggregateRootDeletedAt deletedAt, AggregateRootIsDeleted isDeleted, AggregateRootUpdatedAt updatedAt) {
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.isDeleted = isDeleted;
        this.updatedAt = updatedAt;
    }

    public abstract Primitives toPrimitives();
}

package com.raulvalesc.favslistsapi.shared.domain.aggregate;

import com.raulvalesc.favslistsapi.shared.domain.bus.event.DomainEvent;
import com.raulvalesc.favslistsapi.shared.domain.entity.Entity;
import com.raulvalesc.favslistsapi.shared.domain.entity.EntityCreatedAt;
import com.raulvalesc.favslistsapi.shared.domain.entity.EntityDeletedAt;
import com.raulvalesc.favslistsapi.shared.domain.entity.EntityIsDeleted;
import com.raulvalesc.favslistsapi.shared.domain.entity.EntityPrimitives;
import com.raulvalesc.favslistsapi.shared.domain.entity.EntityUpdatedAt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AggregateRoot<Primitives extends EntityPrimitives> extends Entity<Primitives> {
    private List<DomainEvent> domainEvents = new ArrayList<>();

    protected AggregateRoot(EntityCreatedAt createdAt, EntityDeletedAt deletedAt, EntityIsDeleted isDeleted, EntityUpdatedAt updatedAt) {
        super(createdAt, deletedAt, isDeleted, updatedAt);
    }

    protected void record(DomainEvent event) {
        domainEvents.add(event);
    }

    public List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> events = domainEvents;
        domainEvents = new ArrayList<>();
        return Collections.unmodifiableList(events);
    }
}

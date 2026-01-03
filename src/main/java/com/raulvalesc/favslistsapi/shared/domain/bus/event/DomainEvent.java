package com.raulvalesc.favslistsapi.shared.domain.bus.event;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {
    private final String eventId;
    private final String aggregateId;
    private final Instant occurredOn;

    protected DomainEvent(String aggregateId) {
        this.eventId = UUID.randomUUID().toString();
        this.aggregateId = aggregateId;
        this.occurredOn = Instant.now();
    }

    protected DomainEvent(String eventId, String aggregateId, Instant occurredOn) {
        this.eventId = eventId;
        this.aggregateId = aggregateId;
        this.occurredOn = occurredOn;
    }

    public String getEventId() {
        return eventId;
    }

    public String getAggregateId() {
        return aggregateId;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    public abstract String getEventName();
}

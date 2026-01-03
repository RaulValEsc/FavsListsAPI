package com.raulvalesc.favslistsapi.shared.domain.bus.event;

public interface EventHandler<E extends DomainEvent> {
    void handle(E event);
}

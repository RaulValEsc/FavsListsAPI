package com.raulvalesc.favslistsapi.shared.domain.bus.event;

import java.util.List;

public interface EventBus {
    void publish(DomainEvent event);

    void publish(List<DomainEvent> events);
}

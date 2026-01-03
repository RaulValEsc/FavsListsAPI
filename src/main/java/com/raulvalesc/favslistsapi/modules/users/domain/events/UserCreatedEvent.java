package com.raulvalesc.favslistsapi.modules.users.domain.events;

import com.raulvalesc.favslistsapi.shared.domain.bus.event.DomainEvent;

public class UserCreatedEvent extends DomainEvent {
    private final String name;
    private final String email;

    public UserCreatedEvent(String userId, String name, String email) {
        super(userId);
        this.name = name;
        this.email = email;
    }

    @Override
    public String getEventName() {
        return "user.created";
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

package com.raulvalesc.favslistsapi.modules.users.domain.events;

import com.raulvalesc.favslistsapi.shared.domain.bus.event.DomainEvent;

public class UserDeletedEvent extends DomainEvent {

    public UserDeletedEvent(String userId) {
        super(userId);
    }

    @Override
    public String getEventName() {
        return "user.deleted";
    }
}

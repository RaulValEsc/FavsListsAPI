package com.raulvalesc.favslistsapi.shared.domain.entity;

import com.raulvalesc.favslistsapi.shared.domain.valueobjects.InstantValueObject;

import java.time.Instant;

public class EntityDeletedAt extends InstantValueObject {
    public EntityDeletedAt(Instant value) {
        super(value);
    }
}

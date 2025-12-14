package com.raulvalesc.favslistsapi.shared.domain.entity;

import com.raulvalesc.favslistsapi.shared.domain.valueobjects.InstantValueObject;

import java.time.Instant;

public class EntityUpdatedAt extends InstantValueObject {
    public EntityUpdatedAt(Instant value) {
        super(value);
    }
}

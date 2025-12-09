package com.raulvalesc.favslistsapi.shared.domain.aggregateroot;

import com.raulvalesc.favslistsapi.shared.domain.valueobjects.InstantValueObject;

import java.time.Instant;

public class AggregateRootDeletedAt extends InstantValueObject {
    public AggregateRootDeletedAt(Instant value) {
        super(value);
    }
}

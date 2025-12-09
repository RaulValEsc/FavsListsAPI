package com.raulvalesc.favslistsapi.shared.domain.aggregateroot;

import com.raulvalesc.favslistsapi.shared.domain.valueobjects.InstantValueObject;

import java.time.Instant;

public class AggregateRootUpdatedAt extends InstantValueObject {
    public AggregateRootUpdatedAt(Instant value) {
        super(value);
    }
}

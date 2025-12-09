package com.raulvalesc.favslistsapi.shared.domain.aggregateroot;

import com.raulvalesc.favslistsapi.shared.domain.valueobjects.InstantValueObject;

import java.time.Instant;

public class AggregateRootCreatedAt extends InstantValueObject {
    public AggregateRootCreatedAt(Instant value) {
        super(value);
    }
}

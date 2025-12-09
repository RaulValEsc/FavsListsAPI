package com.raulvalesc.favslistsapi.shared.domain.aggregateroot;

import com.raulvalesc.favslistsapi.shared.domain.valueobjects.BooleanValueObject;

public class AggregateRootIsDeleted extends BooleanValueObject {
    public AggregateRootIsDeleted(Boolean value) {
        super(value);
    }
}

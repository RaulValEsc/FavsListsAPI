package com.raulvalesc.favslistsapi.shared.domain.valueobjects;

import java.util.UUID;

public abstract class UuidValueObject extends StringValueObject {
    public UuidValueObject(String value) {
        super(value);

        this.ensureIsAValidUuid(value);
    }

    private void ensureIsAValidUuid(String value) {
        UUID uuid = UUID.fromString(value);
    }
}

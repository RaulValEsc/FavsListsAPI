package com.raulvalesc.favslistsapi.shared.domain.valueobjects;


import java.time.Instant;

public abstract class InstantValueObject {
    public final Instant value;

    protected InstantValueObject(Instant value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InstantValueObject that = (InstantValueObject) o;

        return value.equals(that.value);
    }

    public int hashCode() {
        return value.hashCode();
    }
}

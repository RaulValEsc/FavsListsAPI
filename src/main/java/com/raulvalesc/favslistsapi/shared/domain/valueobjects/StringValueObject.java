package com.raulvalesc.favslistsapi.shared.domain.valueobjects;

import com.raulvalesc.favslistsapi.shared.domain.valueobjects.exceptions.EmptyStringNotValidException;

public abstract class StringValueObject {
    public final String value;

    protected StringValueObject(String value) {
        this.value = value;

        this.ensureIsNotEmptyOrNull(value);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StringValueObject that = (StringValueObject) o;

        return value.equals(that.value);
    }

    public int hashCode() {
        return value.hashCode();
    }

    private void ensureIsNotEmptyOrNull(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new EmptyStringNotValidException();
        }
    }
}

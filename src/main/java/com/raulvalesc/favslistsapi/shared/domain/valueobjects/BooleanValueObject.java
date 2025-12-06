package com.raulvalesc.favslistsapi.shared.domain.valueobjects;

public abstract class BooleanValueObject {
    public final Boolean value;

    protected BooleanValueObject(Boolean value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BooleanValueObject that = (BooleanValueObject) o;

        return value.equals(that.value);
    }

    public int hashCode() {
        return value.hashCode();
    }
}

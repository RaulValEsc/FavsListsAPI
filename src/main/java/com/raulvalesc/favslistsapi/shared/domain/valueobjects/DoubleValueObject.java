package com.raulvalesc.favslistsapi.shared.domain.valueobjects;

public abstract class DoubleValueObject {
    public final Double value;

    protected DoubleValueObject(Double value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DoubleValueObject that = (DoubleValueObject) o;

        return value.equals(that.value);
    }

    public int hashCode() {
        return value.hashCode();
    }
}

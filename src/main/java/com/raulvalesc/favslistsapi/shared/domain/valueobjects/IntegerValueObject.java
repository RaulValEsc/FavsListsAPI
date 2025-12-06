package com.raulvalesc.favslistsapi.shared.domain.valueobjects;

public abstract class IntegerValueObject {
    private final Integer value;

    protected IntegerValueObject(Integer value) {
        this.value = value;
    }

    public Integer value() {
        return value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IntegerValueObject that = (IntegerValueObject) o;

        return value.equals(that.value);
    }

    public int hashCode() {
        return value.hashCode();
    }
}

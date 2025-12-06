package com.raulvalesc.favslistsapi.shared.domain.valueobjects;

public abstract class StringValueObject {
    private final String value;

    protected StringValueObject(String value) {
        this.value = value;
    }

    public String value() {
        return value;
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
}

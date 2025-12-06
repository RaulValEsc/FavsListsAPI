package com.raulvalesc.favslistsapi.shared.domain.valueobjects;

import com.raulvalesc.favslistsapi.shared.domain.valueobjects.exceptions.InvalidEmailException;

public abstract class EmailValueObject extends StringValueObject {
    public EmailValueObject(String value) {
        super(value);

        this.ensureIsAValidEmail(value);
    }

    private void ensureIsAValidEmail(String value) {
        if (!value.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new InvalidEmailException(value);
        }
    }
}

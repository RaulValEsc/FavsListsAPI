package com.raulvalesc.favslistsapi.shared.domain.valueobjects.exceptions;

import com.raulvalesc.favslistsapi.shared.domain.exceptions.InternalServerException;

public class EmptyStringNotValidException extends InternalServerException {
    public EmptyStringNotValidException() {
        super("Empty or nullish strings are not allowed as value object.");
    }
}

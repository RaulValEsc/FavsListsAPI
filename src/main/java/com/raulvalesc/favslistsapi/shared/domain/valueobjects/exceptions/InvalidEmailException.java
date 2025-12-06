package com.raulvalesc.favslistsapi.shared.domain.valueobjects.exceptions;

import com.raulvalesc.favslistsapi.shared.domain.exceptions.BadRequestException;

public class InvalidEmailException extends BadRequestException {
    public InvalidEmailException(String email) {
        super("The given email address '" + email + "' is invalid.");
    }
}

package com.raulvalesc.favslistsapi.shared.domain.exceptions;

public class InternalServerException extends RuntimeException {
    public InternalServerException(String message) {
        super(message);
    }
}

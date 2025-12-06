package com.raulvalesc.favslistsapi.shared.infrastructure.exceptions;

import com.raulvalesc.favslistsapi.shared.domain.exceptions.BadRequestException;
import com.raulvalesc.favslistsapi.shared.domain.exceptions.InternalServerException;
import com.raulvalesc.favslistsapi.shared.domain.exceptions.NotFoundException;
import com.raulvalesc.favslistsapi.shared.domain.exceptions.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getClass().getSimpleName());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ExceptionResponse> handleInternalServerException(InternalServerException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getClass().getSimpleName());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getClass().getSimpleName());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        ExceptionResponse response = new ExceptionResponse(ex.getMessage(), ex.getClass().getSimpleName());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

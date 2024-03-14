package org.makaia.clinica.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice()
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity handleBodyNull(ApiException e){
        ProcessingException exception = new ProcessingException(e.getStatusCode(),
                e.getMessage());
        return new ResponseEntity<ProcessingException>(exception,
                HttpStatus.valueOf(e.getStatusCode()));
    }

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public ResponseEntity handleBodyNull(EmptyResultDataAccessException e){
        ProcessingException exception = new ProcessingException(404,
                e.getMessage());
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(value = DateTimeParseException.class)
    public ResponseEntity handleDateBadFormat(DateTimeParseException e){
        ProcessingException exception = new ProcessingException(404,
                "Error en el ingreso de la fecha");
        return ResponseEntity.badRequest().body(exception);
    }
}
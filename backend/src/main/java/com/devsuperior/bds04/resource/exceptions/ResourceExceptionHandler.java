package com.devsuperior.bds04.resource.exceptions;

import com.devsuperior.bds04.service.exceptions.DataBaseException;
import com.devsuperior.bds04.service.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> ObjectNotFound(ResourceNotFoundException e, HttpServletRequest request){
            StandardError error = new StandardError();
            error.setTimestamp(Instant.now());
            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setError("Resource not found");
            error.setMessage(e.getMessage());
            error.setPath(request.getRequestURI());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> database(ResourceNotFoundException e, HttpServletRequest request){
            StandardError error = new StandardError();
            error.setTimestamp(Instant.now());
            error.setStatus(HttpStatus.BAD_REQUEST.value());
            error.setError("Database Exception");
            error.setMessage(e.getMessage());
            error.setPath(request.getRequestURI());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ValidationError> Validation(MethodArgumentNotValidException e, HttpServletRequest request){
            ValidationError error = new ValidationError();
            error.setTimestamp(Instant.now());
            error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
            error.setError("Validation exception");
            error.setMessage(e.getMessage());
            error.setPath(request.getRequestURI());
            for(FieldError f: e.getBindingResult().getFieldErrors()){
                    error.addError(f.getField(), f.getDefaultMessage());
            }

            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
    }

}

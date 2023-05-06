package com.registrationform.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class ExceptionPerson {

    @ExceptionHandler(value={BadRequest.class})
    public ResponseEntity<?> handelBadRequest(BadRequest badRequest){
        ExceptionResponse response =
                new ExceptionResponse(badRequest.getMessage()
                        , HttpStatus.BAD_REQUEST
                        , LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(RepeatedNationalId.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> handleValidationException(RepeatedNationalId ex) {
        ExceptionResponse response =
                new ExceptionResponse(ex.getMessage()
                        , HttpStatus.BAD_REQUEST
                        , LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

    }





}

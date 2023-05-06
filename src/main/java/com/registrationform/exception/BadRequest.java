package com.registrationform.exception;

public class BadRequest extends RuntimeException{

    public BadRequest(String message){
        super(message);
    }
}

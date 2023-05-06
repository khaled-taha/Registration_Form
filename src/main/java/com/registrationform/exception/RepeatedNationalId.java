package com.registrationform.exception;

public class RepeatedNationalId extends RuntimeException{

    public RepeatedNationalId(String message){
        super(message);
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public RepeatedNationalId() {
    }
}

package com.example.shikusi_dipensary.exceptions;

public class PatientNotFoundException extends RuntimeException{

    public PatientNotFoundException( String message) {
        super(message);
    }
}

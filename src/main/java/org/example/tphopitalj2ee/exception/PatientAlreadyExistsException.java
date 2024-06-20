package org.example.tphopitalj2ee.exception;

public class PatientAlreadyExistsException extends RuntimeException{
    public PatientAlreadyExistsException(String message) {
        super(message);
    }
}

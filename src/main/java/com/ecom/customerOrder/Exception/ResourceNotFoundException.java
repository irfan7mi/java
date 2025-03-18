package com.ecom.customerOrder.exception;  // Correct package for exceptions

public class ResourceNotFoundException extends RuntimeException {

    // Constructor for error message
    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Constructor for error message and cause
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

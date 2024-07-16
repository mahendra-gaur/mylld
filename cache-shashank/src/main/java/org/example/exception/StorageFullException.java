package org.example.exception;

public class StorageFullException extends RuntimeException{
    public StorageFullException(String message) {
        super(message);
    }
}

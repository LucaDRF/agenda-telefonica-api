package com.agenda_telefonica.error;

public abstract class BaseError extends RuntimeException {
    abstract public int getStatus();

    public BaseError(String message) {
        super(message);
    }
}

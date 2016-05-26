package com.malexj.exception;

public class NoFoundUserException extends Exception {

    public NoFoundUserException() {
    }

    public NoFoundUserException(String message) {
        super(message);
    }

    public NoFoundUserException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.malexj.exception;

public class FailedCreateAccountException extends Exception {
    public FailedCreateAccountException() {
    }

    public FailedCreateAccountException(String message) {
        super(message);
    }

    public FailedCreateAccountException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.malexj.exception;

public class ImageNotAvailableException extends Exception {
    public ImageNotAvailableException() {
    }

    public ImageNotAvailableException(String message) {
        super(message);
    }

    public ImageNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}

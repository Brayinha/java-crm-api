package com.example.application.common.exceptions;

import org.springframework.http.HttpStatus;

public class TechnicalException extends Exception {

    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public TechnicalException() {
        super();
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getStatus() {
    	return this.status;
    }

}

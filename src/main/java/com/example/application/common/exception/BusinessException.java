package com.example.application.common.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {

    private HttpStatus status = HttpStatus.BAD_REQUEST;
    
    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public HttpStatus getStatus() {
    	return this.status;
    }

}

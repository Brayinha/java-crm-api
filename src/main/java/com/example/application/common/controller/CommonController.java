package com.example.application.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.example.application.common.exceptions.BusinessException;
import com.example.application.common.exceptions.TechnicalException;

public class CommonController {
	
	protected ResponseEntity<?> throwExceptionResponse(BusinessException e) {
    	return this.buildResponse(this.buildMessage(e.getMessage()), e.getStatus());
	}

	protected ResponseEntity<?> throwExceptionResponse(TechnicalException e) {
    	return this.buildResponse(this.buildMessage(e.getMessage()), e.getStatus());
	}

    /**
     * Builds a generic response
     * @param message
     * @param status
     * @return generic response
     */
    protected ResponseEntity<?> buildResponse(Object object, HttpStatus status) {
        return new ResponseEntity<Object>(object, status);
    }

    /**
     * Builds a generic message
     * @param message
     * @return generic message
     */
    protected ObjectNode buildMessage(String message) {
        return new ObjectMapper().createObjectNode().put("message", message);
    }

}

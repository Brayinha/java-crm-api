package com.example.application.foundation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.application.common.controller.CommonController;
import com.example.application.common.exception.BusinesException;
import com.example.application.common.exception.TechnicalException;

@RestController
@RequestMapping("/v1")
public class CustomerController extends CommonController {
	
    @Autowired
    private CustomerService service;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Long id) throws BusinesException, TechnicalException {

        var customer = service.findById(id);

        if (customer != null) {
            return this.buildResponse(customer, HttpStatus.OK);
        } else {
            return this.buildResponse(
                this.buildMessage("not_found"),
                HttpStatus.NOT_FOUND
            );
        }
    }

}

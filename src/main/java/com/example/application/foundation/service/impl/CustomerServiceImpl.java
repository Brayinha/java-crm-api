package com.example.application.foundation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.common.exceptions.BusinessException;
import com.example.application.common.exceptions.TechnicalException;
import com.example.application.foundation.entity.Customer;
import com.example.application.foundation.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
    @Autowired
    private CustomerRepository repository;
    
    @Override
    public Item findById(Long id) throws BusinessException, TechnicalException {

        if (id == null || id.equals(0L)) {
            throw new BusinessException("Item ID is required.");
        }

        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new TechnicalException(e);
        }
    }

}

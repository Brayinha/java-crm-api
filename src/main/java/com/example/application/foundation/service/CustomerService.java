package com.example.application.foundation.service;

import com.example.application.common.exceptions.BusinessException;
import com.example.application.common.exceptions.TechnicalException;
import com.example.application.foundation.entity.Customer;

public interface CustomerService {
	
    /**
     * Gets customer data by id
     * @param id
     * @return item
     * @throws BusinessException
     * @throws TechnicalException
     */
    Customer findById(Long id) throws BusinessException, TechnicalException;

}

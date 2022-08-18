package com.example.application.foundation.service;

import com.example.application.common.exceptions.BusinessException;
import com.example.application.common.exceptions.TechnicalException;
import com.example.application.foundation.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
	

    Page<Customer> listAllPageable(Pageable pageable);
    List<Customer> listlistAllNonPageable();
    Optional<Customer> findById(UUID id) throws BusinessException, TechnicalException;
    Customer save(Customer customer);
    void delete(UUID id);


}

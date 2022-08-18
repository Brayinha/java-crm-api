package com.example.application.foundation.service.impl;

import com.example.application.common.exceptions.BusinessException;
import com.example.application.common.exceptions.TechnicalException;
import com.example.application.foundation.entity.Customer;
import com.example.application.foundation.repository.CustomerRepository;
import com.example.application.foundation.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Customer> listAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> listlistAllNonPageable() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findById(UUID id) throws BusinessException, TechnicalException {

        if (Objects.isNull(id) || id.equals(0L)) throw new BusinessException("Item ID is required.");
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new TechnicalException(e);
        }
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return repository.save(customer);
    }



    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}

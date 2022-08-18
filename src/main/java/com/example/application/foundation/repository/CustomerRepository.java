package com.example.application.foundation.repository;


import java.util.UUID;

import com.example.application.foundation.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Customer findById(Long UUID);
}

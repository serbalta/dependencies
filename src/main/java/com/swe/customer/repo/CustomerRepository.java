package com.swe.customer.repo;

import com.swe.customer.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository
        extends MongoRepository<Customer,String> {



}

package com.swe.customer.service;


import com.swe.customer.entity.Customer;
import com.swe.customer.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public  Customer update(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer insertCustomer(Customer customer){
        return customerRepository.save(customer);
    }


}

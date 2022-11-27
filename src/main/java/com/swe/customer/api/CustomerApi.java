package com.swe.customer.api;

import com.swe.customer.CustomerApplication;
import com.swe.customer.entity.Customer;
import com.swe.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@AllArgsConstructor
public class CustomerApi {
    private final CustomerService customerService;

    @GetMapping
    public List<Customer> fetchAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping
    public Customer updateCustomer(Customer customer){

        return customerService.update(customer);
    }

    @PutMapping
    public Customer insertCustomer(Customer customer){
        return customerService.insertCustomer(customer);
    }




}

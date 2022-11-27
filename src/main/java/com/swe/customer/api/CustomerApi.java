package com.swe.customer.api;

import com.swe.customer.CustomerApplication;
import com.swe.customer.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customers")
@AllArgsConstructor
public class CustomerApi {
    private final CustomerApi customerApi;

    @GetMapping
    public List<Customer> fetchAllCustomers(){
        return customerApi.getAllCustomers();
    }



}

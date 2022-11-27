package com.swe.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class Product {

    private String code;
    private String name;
    int balance;
    private int interestRate;






}

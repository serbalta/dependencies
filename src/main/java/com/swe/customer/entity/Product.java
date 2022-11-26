package com.swe.customer.entity;

import lombok.Data;

@Data
public class Product {
    private String name;
    private String code;
    private int balance;
    private int interestRate;

}

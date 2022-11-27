package com.swe.customer.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor
public class Product {
    @Id
    private String code;
    @NonNull
    private String name;
    @NonNull
    private int balance;
    @NonNull
    private int interestRate;






}

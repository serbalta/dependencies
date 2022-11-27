package com.swe.customer.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@RequiredArgsConstructor
public class Customer {


    @Id
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    @Indexed(unique = true)
    private String email;
    @NonNull
    private Gender gender;
    @NonNull
    private Adress adress;
    @NonNull
    private List<Product> products;
    @NonNull
    private int totalPrice;






}

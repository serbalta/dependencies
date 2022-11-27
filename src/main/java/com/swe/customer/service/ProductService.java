package com.swe.customer.service;

import com.swe.customer.entity.Customer;
import com.swe.customer.entity.Product;
import com.swe.customer.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }


    public Product updateProduct(Product product){

        return productRepository.save(product);
    }

    public Product insertProduct(Product product){
        return productRepository.save(product);
    }


}

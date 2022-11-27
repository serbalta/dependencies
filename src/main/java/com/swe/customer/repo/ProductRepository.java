package com.swe.customer.repo;

import com.swe.customer.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface ProductRepository extends MongoRepository<Product , String> {

    Collection<? extends Product> findAllByName(String name);

}

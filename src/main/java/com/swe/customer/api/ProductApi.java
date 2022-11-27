package com.swe.customer.api;

import com.swe.customer.entity.Product;
import com.swe.customer.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("products")
public class ProductApi {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product updateProduct(Product product){

        return productService.updateProduct(product);
    }

    @PutMapping
    public Product insertProduct(Product product){
        return productService.insertProduct(product);
    }

}

package com.swe.customer;

import com.swe.customer.entity.Adress;
import com.swe.customer.entity.Customer;
import com.swe.customer.entity.Gender;
import com.swe.customer.entity.Product;
import com.swe.customer.repo.CustomerRepository;
import com.swe.customer.repo.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootApplication
public class CustomerApplication {


    public static void main(String[] args) {

        SpringApplication.run(CustomerApplication.class, args);
    }



    @Bean
    CommandLineRunner runner(ProductRepository productRepo, CustomerRepository repository, MongoTemplate mongoTemplate) {
        return args -> {

            Product product = new Product("1", "Apple", 147, 10);
            Product product2 = new Product("2", "Samsung", 100, 10);

            productRepo.insert(product);
            productRepo.insert(product2);

            Adress adress = new Adress(
                    "Turkei",
                    "Yalova",
                    "77100"
            );


            Customer customer = new Customer(
                    "salih",
                    "Erbalta",
                    "se22m061@tecknikum-wien.at",
                    Gender.MALE,
                    adress,
                    (List<Product>) productRepo.findAllByName("Apple"),
                    sumOfBalance((List<Product>) productRepo.findAllByName("Apple"))
            );


            Adress adress2 = new Adress(
                    "Turkei",
                    "Yalova",
                    "77100"
            );


            Customer customer2 = new Customer(
                    "Muster",
                    "Mustermann",
                    "Mustermann@tecknikum-wien.at",
                    Gender.MALE,
                    adress2,
                    (List<Product>) productRepo.findAllByName("Samsung"),
                    sumOfBalance((List<Product>) productRepo.findAllByName("Samsung"))
            );


            isExist(repository, customer, customer2);

        };

    }

    private static void isExist(CustomerRepository repository, Customer customer, Customer customer2) {
        List<Customer> customers = repository.findAll();
        System.out.println(customers);
        if(customers.isEmpty()){
            repository.insert(customer);
            repository.insert(customer2);
        }
        else{
            for (Customer c : customers) {
                if (repository.findByEmail(c.getEmail()) == null) {
                    repository.insert(c);
                } else {

                    System.out.println("Already exist");
                }

            }
        }
    }


    private int sumOfBalance(List<Product> products) {
        int sum = 0;
        for (Product p : products) {
            sum += p.getBalance();
        }

        return sum;
    }


}

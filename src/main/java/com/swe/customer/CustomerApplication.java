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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CustomerApplication {


	public static void main(String[] args) {

		SpringApplication.run(CustomerApplication.class, args);
	}
	List<Product> products = new ArrayList<Product>();


	@Bean
	CommandLineRunner runner(ProductRepository productRepo, CustomerRepository repository, MongoTemplate mongoTemplate)
	{
		return args ->{

			Product product = new Product("apple" , 3 ,10);





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
					products,
					123
			);




			Query query = new Query();
			query.addCriteria(Criteria.where("email").exists(true));
			List<Customer> customers = mongoTemplate.find(query, Customer.class);
			if (customers.size()>1){
				throw new IllegalStateException( "email already used");
			}

			if(customers.isEmpty()){
				System.out.println(customer + " added");
				repository.insert(customer);
			}
			else{
				System.out.println(customer + " Already exist");
			}

			productRepo.insert(product);
		};

	}

}

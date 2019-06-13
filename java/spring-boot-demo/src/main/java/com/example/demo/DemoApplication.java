package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return args -> {
            repository.save(new Customer("Father","Ted"));
            repository.save(new Customer("Mike", "Rotch"));
            repository.save(new Customer("Mother", "Mary"));
            repository.save(new Customer("Som ting", "Wong"));

            log.info("This is a test of the logger System");
            log.info("This is the data stored in the customer db");
            for(Customer customer: repository.findAll()) {
                log.info(customer.toString());
            }

            ArrayList<Long> l1 = new ArrayList<>();
            l1.add(new Long(1));
            l1.add(new Long(3));

            for(Customer c: repository.findAllById(l1)) {
                log.info(c.toString());
            }

//            List<Customer> lastNames = repository.findByLastName("Fuk");
//            for (Customer c: lastNames) {
//                log.info(c.toString());
//            }
        };
    }

}

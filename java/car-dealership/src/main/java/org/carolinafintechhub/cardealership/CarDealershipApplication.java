package org.carolinafintechhub.cardealership;

import org.carolinafintechhub.cardealership.model.Car;
import org.carolinafintechhub.cardealership.model.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Year;

@SpringBootApplication
public class CarDealershipApplication {

    private static final Logger LOG = LoggerFactory.getLogger(CarDealershipApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CarDealershipApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CarRepository repository) {
        return args -> {
            repository.save(new Car("Mazda","3", Year.parse("2019"),false));
            repository.save(new Car("Mitsubishi","Eclipse",Year.parse("2001"),true));
            repository.save(new Car("Dodge", "Stratus",Year.parse("1999"),false));
            repository.save(new Car("Izuzu","Hombre",Year.parse("1998"),true));
            repository.save(new Car("Mazda","6",Year.parse("2019"),false));
            repository.save(new Car("Dodge","Stratus",Year.parse("2004"),true));

            LOG.info("Stored Car Dealership Data");
            for(Car c: repository.findAll()) {
                LOG.info(c.toString());
            }

            LOG.info("preowned vehicles");
            for(Car c: repository.findByPreowned(true)) {
                LOG.info(c.toString());
            }

            LOG.info("Mazdas");
            for (Car c: repository.findByMake("Mazda")) {
                LOG.info(c.toString());
            }

            LOG.info("Selling an Izuzu Hombre");
            repository.deleteById(repository.findByMake("Izuzu").get(Integer.parseInt("0")).getId());
            for (Car c: repository.findAll()) {
                LOG.info(c.toString());
            }
        };
    }
}

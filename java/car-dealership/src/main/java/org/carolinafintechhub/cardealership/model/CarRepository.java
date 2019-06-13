package org.carolinafintechhub.cardealership.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car,Integer> {

    List<Car> findByPreowned(Boolean preowned);
    List<Car> findByMake(String make);

}

package org.carolinafintechhub.cardealership.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Year;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String make;
    private String model;
    private Year year;
    private Boolean preowned;

    public Car() {
        //default no arg constructor
    }

    public Car(String make, String model, Year year, Boolean preowned) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.preowned = preowned;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Boolean getPreowned() {
        return preowned;
    }

    public void setPreowned(Boolean preowned) {
        this.preowned = preowned;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", preowned=" + preowned +
                '}';
    }
}

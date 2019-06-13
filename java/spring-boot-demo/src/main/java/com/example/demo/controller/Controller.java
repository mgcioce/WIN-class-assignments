package com.example.demo.controller;

import com.example.demo.model.CustomerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private CustomerRepository db;

    public Controller(CustomerRepository db) {
        this.db = db;
    }

    @RequestMapping(method = {RequestMethod.GET},path = {"/"})
    public String home() {
        return "Hello, World!";
    }

}
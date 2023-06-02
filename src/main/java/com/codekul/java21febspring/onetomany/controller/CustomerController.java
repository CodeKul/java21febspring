package com.codekul.java21febspring.onetomany.controller;

import com.codekul.java21febspring.onetomany.entity.Customer;
import com.codekul.java21febspring.onetomany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("saveCustomer")
    public String saveCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return "customer saved.";
    }
}

/**
 *
 * {
 *
 *     "product": [
 *         {
 *             "pName": "Fan",
 *             "price": 66.0
 *         },
 *         {
 *             "pName": "AC",
 *             "price": 664.0
 *         }
 *     ],
 *     "name": "Jeevan",
 *     "address": "Mumabi"
 * }
 */
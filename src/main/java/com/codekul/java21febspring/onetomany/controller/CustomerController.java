package com.codekul.java21febspring.onetomany.controller;

import com.codekul.java21febspring.onetomany.dto.CustomerRequestDto;
import com.codekul.java21febspring.onetomany.entity.Customer;
import com.codekul.java21febspring.onetomany.repository.CustomerRepository;
import com.codekul.java21febspring.onetomany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private ProductService productService;

    @PostMapping("save")
    public String saveCustomer( @RequestBody CustomerRequestDto customer) {
        return productService.saveCustomer(customer);
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
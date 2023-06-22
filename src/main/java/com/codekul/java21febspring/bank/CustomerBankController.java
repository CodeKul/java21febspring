package com.codekul.java21febspring.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerBankController {

    @Autowired
    private CustomerBankRepo customerBankRepo;

    @PostMapping("saveCustomer")
    private CustomerBank saveCustomer(@RequestBody CustomerBank customerBank) {
        var customer = new CustomerBank();
        customer.setName(customerBank.getName());
        customer.setAddress(customerBank.getAddress());
        Long acc = customerBankRepo.getAccCount();
        customer.setAccountNumber(String.format("%010d", ++acc));
        customer.setBalance(customerBank.getBalance());
        return customerBankRepo.save(customer);
    }

}

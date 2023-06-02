package com.codekul.java21febspring.onetomany.repository;

import com.codekul.java21febspring.onetomany.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}

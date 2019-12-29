package com.example.DemoGraphQL.repository;
 
import com.example.DemoGraphQL.model.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

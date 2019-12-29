package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Customer;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.CustomerRepository;

import java.util.Optional;

public class CustomerResolver implements GraphQLResolver<Customer> {
    private CustomerRepository customerRepository;

    public CustomerResolver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    public Optional<Customer> getAuthor(Customer book) {
//        return authorRepository.findById(book.getAuthor().getId());
//    }
}

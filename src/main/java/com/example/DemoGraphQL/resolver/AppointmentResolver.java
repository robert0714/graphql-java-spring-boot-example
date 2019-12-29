package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.*; 
import com.example.DemoGraphQL.repository.*; 

import java.util.Optional;

public class AppointmentResolver implements GraphQLResolver<Appointment> {
    private AppointmentRepository appointmentRepository;

    public AppointmentResolver(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

//    public Optional<Customer> getAuthor(Customer book) {
//        return authorRepository.findById(book.getAuthor().getId());
//    }
}

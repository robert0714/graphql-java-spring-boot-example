package com.example.DemoGraphQL.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.Appointment;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Customer;
import com.example.DemoGraphQL.repository.AppointmentRepository;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.CustomerRepository;

public class Query implements GraphQLQueryResolver {
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private CustomerRepository customerRepository;
	private AppointmentRepository appointmentRepository;

	public Query(AuthorRepository authorRepository, BookRepository bookRepository,
			CustomerRepository customerRepository, AppointmentRepository appointmentRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.customerRepository = customerRepository;
		this.appointmentRepository = appointmentRepository;
	}

	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public long countBooks() {
		return bookRepository.count();
	}

	public long countAuthors() {
		return authorRepository.count();
	}

	public Optional<Customer> customer(long id) {
		Optional<Customer> result = customerRepository.findById(id);
		return result;
	}

	public Iterable<Customer> customers() {
		return customerRepository.findAll();
	}

	public Iterable<Appointment> availableTimeSlots() {
		return appointmentRepository.findAll();
	}

	public Iterable<Appointment> appointments(String from, String to) {
		return appointmentRepository.findAll();
	}
}

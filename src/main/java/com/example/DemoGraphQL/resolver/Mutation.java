package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DemoGraphQL.exception.BookNotFoundException;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.*;

import java.util.Optional;

public class Mutation implements GraphQLMutationResolver {
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private CustomerRepository customerRepository;
	private AppointmentRepository appointmentRepository;

	public Mutation(AuthorRepository authorRepository, BookRepository bookRepository,
			CustomerRepository customerRepository, AppointmentRepository appointmentRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.customerRepository = customerRepository;
		this.appointmentRepository = appointmentRepository;
	}

	public Appointment addAppointment(Appointment appointment) {
		Appointment result = appointmentRepository.save(appointment);
		return result;
	}

	public Customer addCustomer(Customer customer) {
		Customer result = customerRepository.save(customer);
		return result;
	}

	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);

		authorRepository.save(author);

		return author;
	}

	public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
		Book book = new Book();
		book.setAuthor(new Author(authorId));
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setPageCount(pageCount != null ? pageCount : 0);

		bookRepository.save(book);

		return book;
	}

	public boolean deleteBook(Long id) {
		bookRepository.deleteById(id);
		return true;
	}

	public Book updateBookPageCount(Integer pageCount, Long id) {
		Optional<Book> book = bookRepository.findById(id);

		book.get().setPageCount(pageCount);

		bookRepository.save(book.get());

		return book.get();
	}
}

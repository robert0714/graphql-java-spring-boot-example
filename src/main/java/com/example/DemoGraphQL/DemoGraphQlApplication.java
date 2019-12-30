package com.example.DemoGraphQL;

import com.example.DemoGraphQL.exception.GraphQLErrorAdapter;
import com.example.DemoGraphQL.model.Appointment;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Customer;
import com.example.DemoGraphQL.repository.AppointmentRepository;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.CustomerRepository;
import com.example.DemoGraphQL.resolver.*;
import com.github.javafaker.Faker;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphQlApplication.class, args);
	}

	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream().filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream().filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new).collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

	@Bean
	public AppointmentResolver appointmentResolver(AppointmentRepository appointmentRepository) {
		return new AppointmentResolver(appointmentRepository);
	}

	@Bean
	public CustomerResolver customerResolver(CustomerRepository customerRepository) {
		return new CustomerResolver(customerRepository);
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository,
			CustomerRepository customerRepository, AppointmentRepository appointmentRepository) {
		return new Query(authorRepository, bookRepository, customerRepository, appointmentRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository,
			CustomerRepository customerRepository, AppointmentRepository appointmentRepository) {
		return new Mutation(authorRepository, bookRepository, customerRepository, appointmentRepository);
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository,
			CustomerRepository customerRepository, AppointmentRepository appointmentRepository) {
		return (args) -> {
			Author author = new Author("Herbert", "Schildt");
			authorRepository.save(author);

			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));

			for (int i = 0; i < 20; ++i) {
				appointmentRepository
						.save(new Appointment("1546045200000", stylists[RandomUtils.nextInt(0, stylists.length - 1)],
								services[RandomUtils.nextInt(0, services.length - 1)], "notes"));
			}

			for (int i = 0; i < 20; ++i) {
				customerRepository.save(generateFakeCustomer());
			}

		};
	}

	private String[] services = { "Cut", "Blow-dry", "Cut & color", "Beard trim", "Cut & beard trim", "Extensions" };

	private String[] stylists = { "Ashley", "Jo", "Pat", "Sam" };

	private Customer generateFakeCustomer() {
		Faker faker = new Faker();
		Customer result = new Customer();
		result.setFirstName(faker.name().firstName());
		result.setLastName(faker.name().lastName());
		result.setPhoneNumber(faker.phoneNumber().phoneNumber());
//		Appointment[] appointments= {generateFakeAppointment() };
//		result.setAppointments(appointments);
		return result;
	}
	private Appointment generateFakeAppointment() {
		Faker faker = new Faker();
		Appointment result = new Appointment();
		result.setNotes(faker.chuckNorris().fact());
		result.setStylist(faker.hipster().toString());
		result.setService(faker.ancient().titan());
		
		result.setStartsAt(String.valueOf(new Date().getTime()));
		return result ; 
	}
}

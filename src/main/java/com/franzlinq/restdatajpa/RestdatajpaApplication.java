package com.franzlinq.restdatajpa;

import com.franzlinq.restdatajpa.entities.Book;
import com.franzlinq.restdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class RestdatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestdatajpaApplication.class, args);

		BookRepository repository = context.getBean(BookRepository.class);

		Book harryPotter = new Book(null, "Harry Potter and the Deadly Hollows",
				"J.K Rowling", 640, 30.0, LocalDate.of(2007, 1, 20), true);
		repository.save(harryPotter);
	}

}

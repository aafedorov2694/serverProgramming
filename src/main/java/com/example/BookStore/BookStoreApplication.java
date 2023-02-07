package com.example.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import com.example.BookStore.domain.Book;
import com.example.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner book (BookRepository repository) {
	return (args) -> {
		
		repository.save(new Book("Bible", "God", 0, "556554-23", (float) 15.26));
		repository.save(new Book("Animal Farm", "George Orwell", 1929, "55679874-23", (float) 15.26));
		repository.save(new Book("A Farwell to Arms", "Ernest Hemingway", 1945, "556554-23", (float) 15.26));
	
	};
	}

}
